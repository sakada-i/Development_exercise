package jp.co.sss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.sss.dto.DBManager;
import jp.co.sss.dto.Department;

public class DepartmentDao {

	public static Department findById(int deptId) {

		Connection con = null;
		PreparedStatement ps = null;

		Department department = null;
		try {
			con = DBManager.getConnection();
			// プリペアドステートメントを用いたSQLの発行
			ps = con.prepareStatement("SELECT * FROM department where dept_id = ?");
			ps.setInt(1, deptId);
			// executeQueryでSQL文を実行し結果をResultSetインターフェースに格納する
			ResultSet rs = ps.executeQuery();
			// ResultSetに格納した結果をwhile文を使って繰り返し取得する
			while (rs.next()) {
				department = new Department();
				department.setDeptId(rs.getInt("dept_id"));
				department.setDeptName(rs.getString("dept_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}

		return department;
	}

}

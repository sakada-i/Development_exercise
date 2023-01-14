package jp.co.sss.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.dto.DBManager;
import jp.co.sss.dto.Department;
import jp.co.sss.dto.Employee;

public class EmployeeDao {
	
	/** 画面タイプ */
	private String displayType = "";

	/**
	 * 画面タイプを返します
	 * @return
	 */
	public String getDisplayType() {
		return displayType;
	}

	/**
	 * 画面タイプを設定します
	 * @param displayType
	 */
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	/**
	 * 職員検索するメソッド
	 * @param empId   社員ID
	 * @param empPass パスワード
	 * @return result
	 * @throws ParseException 
	 */
	public static Employee findEmp(String empId, String empPass) throws ParseException {

		Connection con = null;
		PreparedStatement ps = null;
		Employee employee = new Employee();
		String sql = "";
		if ("notpass".equals(empPass)) {
			sql = "SELECT * FROM employee WHERE emp_id = ?";
		} else {
			sql = "SELECT * FROM employee WHERE emp_id = ? AND emp_pass = ?";
		}
		try {
			// DB接続内容記述
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(empId));
			if (!"notpass".equals(empPass)) {
				ps.setString(2, empPass);
			}
	
			// 取得データ格納内容記述
			ResultSet rs = ps.executeQuery();
		
			Date birthday = null;
			if (rs.next()) {
				employee.setEmpId(rs.getInt("emp_id"));
				employee.setEmpPass(rs.getString("emp_pass"));
				employee.setEmpName(rs.getString("emp_name"));
				employee.setGender(rs.getInt("gender"));
				employee.setAddress(rs.getString("address"));
				birthday = (Date) new SimpleDateFormat(
						"YYYY/MM/dd").parse(rs.getString("birthday")
					);
				employee.setBirthday(birthday);
				employee.setAuthority(rs.getInt("authority"));
				employee.setDeptId(rs.getInt("dept_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}

		return employee;
	}

	/**
	 * 社員全件取得するメソッド
	 * @return
	 * @throws ParseException 
	 */
	public static List<Employee> findAll() throws ParseException {

		Connection con = null;
		PreparedStatement ps = null;

		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			
			con = DBManager.getConnection();
			
			ps = con.prepareStatement(""
					+ "SELECT * "
					+ "FROM employee e "
					+ "INNER join department d "
					+ "ON e.dept_id = d.dept_id"
					);
			
			ResultSet rs = ps.executeQuery();
			
			Date birthday = null;
			while(rs.next()) {

				Employee employee = new Employee();
				employee.setEmpId(rs.getInt("emp_id"));
				employee.setEmpPass(rs.getString("emp_pass"));
				employee.setEmpName(rs.getString("emp_name"));
				// 【性別判定】 1:男性 2:女性
				// TODO 性別：int型で受け取るためjsp側で表示を切り替える
				employee.setGender(rs.getInt("gender"));
				employee.setAddress(rs.getString("address"));
				birthday = (Date) new SimpleDateFormat(
						"YYYY/MM/dd").parse(rs.getString("birthday")
								);
				employee.setBirthday(birthday);
				// 【権限判定】 1:一般 2:管理者
				// TODO 権限：int型で受け取るためjsp側で表示を切り替える
				employee.setAuthority(rs.getInt("authority"));

				Department department = new Department();
				department.setDeptId(rs.getInt("dept_id"));
				department.setDeptName(rs.getString("dept_name"));
				
				employee.setDepartment(department);
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}

		return employeeList;
	}
	
	public static void insert(Employee employee) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBManager.getConnection();
			// 職員登録SQL発行
			ps = con.prepareStatement("INSERT INTO employee"
					+ "("
					+ "emp_pass,"
					+ "emp_name,"
					+ "gender,"
					+ "address,"
					+ "birthday,"
					+ "authority,"
					+ "dept_id"
					+ ") VALUES ("
					+ "?,?,?,?,?,?,?"
					+ ")"
				);
			
			// SQLへ渡すパラメータを設定
			ps.setString(1, employee.getEmpPass());
			ps.setString(2, employee.getEmpName());
			ps.setInt(3, employee.getGender());
			ps.setString(4, employee.getAddress());
			ps.setDate(5, employee.getBirthday());
			ps.setInt(6, employee.getAuthority());
			ps.setInt(7, employee.getDeptId());
			// SQL実行
			int result = ps.executeUpdate();
			// 登録件数をコンソールへ出力
			System.out.println(result);
			// コミット実行※これやらないとDBへ反映されない
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DBコネクションを閉じる
			DBManager.close(ps, con);
		}
	}
	
	/**
	 * 職員削除を実行するメソッド
	 * @param empId
	 */
	public static void delete(String empId) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBManager.getConnection();
			// deleteSQL発行
			ps = con.prepareStatement("DELETE FROM employee WHERE emp_id = ?");
			// SQLへ渡すパラメータを設定
			ps.setInt(1, Integer.parseInt(empId));
			// SQL実行
			int result = ps.executeUpdate();
			// 削除件数をコンソールへ出力
			System.out.println(result);
			// コミット実行※これやらないとDBへ反映されない
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DBコネクションを閉じる
			DBManager.close(ps, con);
		}
	}
}

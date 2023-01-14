package jp.co.sss.servlet.regist;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.sss.dao.DepartmentDao;
import jp.co.sss.dto.Department;
import jp.co.sss.dto.Employee;

@WebServlet("/regist_input")
public class RegistInput extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		String gender = request.getParameter("gender");
		String authority = request.getParameter("authority");
		String deptId = request.getParameter("dept_id");

		Date birthday = null;
		try {
			birthday = (Date) new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("birthday"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Employee employee = new Employee();
		employee.setEmpPass(request.getParameter("emp_pass"));
		employee.setEmpName(request.getParameter("emp_name"));
		employee.setGender(Integer.parseInt(gender));
		employee.setAddress(request.getParameter("address"));
		employee.setBirthday(birthday);
		employee.setAuthority(Integer.parseInt(authority));
		Department department = DepartmentDao.findById(Integer.parseInt(deptId));
		employee.setDepartment(department);
//		EmployeeDao.insert(employee);
		// 遷移先の画面を指定
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/jsp/regist/regist_check.jsp").forward(request, response);;
	}
}

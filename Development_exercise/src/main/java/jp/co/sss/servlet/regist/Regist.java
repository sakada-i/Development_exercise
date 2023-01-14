package jp.co.sss.servlet.regist;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.sss.dao.DepartmentDao;
import jp.co.sss.dao.EmployeeDao;
import jp.co.sss.dto.Department;
import jp.co.sss.dto.Employee;

@WebServlet("/regist")
public class Regist extends HttpServlet {
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
//		employee.setEmpId(Integer.parseInt(empId));
		employee.setEmpPass(request.getParameter("emp_pass"));
		employee.setEmpName(request.getParameter("emp_name"));
		employee.setGender(Integer.parseInt(gender));
		employee.setAddress(request.getParameter("address"));
		employee.setBirthday(birthday);
		employee.setAuthority(Integer.parseInt(authority));
		Department department = DepartmentDao.findById(Integer.parseInt(deptId));
		employee.setDepartment(department);
		EmployeeDao.insert(employee);
	}
}
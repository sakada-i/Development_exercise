package jp.co.sss.servlet.update;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.sss.dao.DepartmentDao;
import jp.co.sss.dto.Department;
import jp.co.sss.dto.Employee;

@WebServlet("/update_check")
public class UpdateCheck extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pass = request.getParameter("emp_pass");
		String name = request.getParameter("emp_name");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		String authority = request.getParameter("authority");
		String deptId = request.getParameter("deptid");

		Department department = DepartmentDao.findById(Integer.parseInt(deptId));
		
		Employee employee = new Employee();
		employee.setEmpPass(pass);
		employee.setEmpName(name);
		employee.setGender(Integer.parseInt(gender));
		employee.setAddress(address);
		employee.setBirthday(birthday);
		employee.setAuthority(Integer.parseInt(authority));
		employee.setDepartment(department);
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/jsp/update/update_check.jsp").forward(request, response);
	}
}

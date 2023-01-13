package jp.co.sss.servlet.delete;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.sss.dao.EmployeeDao;
import jp.co.sss.dto.Employee;

@WebServlet("/delete_input")
public class DeleteInput extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empId = request.getParameter("empid");
		String empPass = "notpass";
		Employee employee = EmployeeDao.findEmp(empId, empPass);
		
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/jsp/delete/delete_check.jsp").forward(request, response);;
	}
}

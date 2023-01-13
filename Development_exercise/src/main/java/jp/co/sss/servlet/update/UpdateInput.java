package jp.co.sss.servlet.update;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.sss.dao.EmployeeDao;
import jp.co.sss.dto.Employee;

@WebServlet("/update_input")
public class UpdateInput extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String empId = request.getParameter("empId");
		String empPass = "notpass";
		Employee employee = EmployeeDao.findEmp(empId, empPass);
		
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/jsp/update/update_input.jsp").forward(request, response);
	}

}

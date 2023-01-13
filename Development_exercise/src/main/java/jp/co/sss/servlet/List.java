package jp.co.sss.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.sss.dto.Employee;

@WebServlet("/list")
public class List extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Employee employee = new Employee();
	
		// hiddenで保持している値をインスタンスに詰めて一覧画面へ返却する
		employee.setEmpId(Integer.parseInt(request.getParameter("empId")));
		employee.setEmpName(request.getParameter("empName"));
		employee.setGender(Integer.parseInt(request.getParameter("gender")));
		employee.setAddress(request.getParameter("address"));
		employee.setBirthday(request.getParameter("birthday"));
		employee.setAuthority(Integer.parseInt(request.getParameter("authority")));
		employee.setDeptId(Integer.parseInt(request.getParameter("deptId")));
		
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/jsp/list.jsp").forward(request, response);;
	}
}

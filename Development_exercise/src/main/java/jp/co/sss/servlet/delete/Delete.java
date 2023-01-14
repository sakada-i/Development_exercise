package jp.co.sss.servlet.delete;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.sss.dao.EmployeeDao;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		String empId = request.getParameter("empId");
		EmployeeDao.delete(empId);
		// 遷移先の画面を指定
		request.getRequestDispatcher("/jsp/delete/delete_complete.jsp").forward(request, response);;
	}
}

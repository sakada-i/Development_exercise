package jp.co.sss.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.sss.dao.EmployeeDao;
import jp.co.sss.dto.Employee;

@WebServlet("/index")
public class Index extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String empId = request.getParameter("empId");
		String empPass = request.getParameter("empPass");
		EmployeeDao displayType = new EmployeeDao();

		// ログイン時に取得した情報は全てセッションに格納する
		// セッションの作成
		HttpSession session = request.getSession();

		// 遷移先の指定
		String url = "/jsp/index.jsp";
		Employee employee = new Employee();
//		List<Employee> employeeList = new ArrayList<Employee>();
		if ("".equals(empId) && "".equals(empPass)) {
			displayType.setDisplayType("not_entered");
			System.out.println("未入力");
		} else if ("".equals(empId)) {
			displayType.setDisplayType("empId_not_entered");
			System.out.println("社員ID項目未入力");
		} else if ("".equals(empPass)) {
			displayType.setDisplayType("empPass_not_entered");
			System.out.println("パスワード項目未入力");
		} else {
			// 職員が存在するか検証
			employee = EmployeeDao.findEmp(empId, empPass);
			// 取得した値をセッションへセット
			// TODO なぜわざわざ時間制限のあるセッションへセットした？
//			session.setAttribute("empId", employee.getEmpId());
//			session.setAttribute("empPass", employee.getEmpPass());
//			session.setAttribute("empName", employee.getEmpName());
//			session.setAttribute("gender", employee.getGender());
//			session.setAttribute("address", employee.getAddress());
//			session.setAttribute("birthday", employee.getBirthday());
//			session.setAttribute("authority", employee.getAuthority());
//			session.setAttribute("deptId", employee.getDeptId());
			if (!"".equals(employee.getEmpName())) {
				url = "/jsp/list.jsp";
				request.setAttribute("employee", employee);
				displayType.setDisplayType("success");
			}

			List<Employee> employeeList = EmployeeDao.findAll();
			request.setAttribute("employeeList", employeeList);
		}
		request.setAttribute("displayType", displayType);
		request.getRequestDispatcher(url).forward(request, response);
	}
}

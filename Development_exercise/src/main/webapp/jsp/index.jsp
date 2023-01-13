<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jp.co.sss.dao.EmployeeDao" %>
<%@ page import="jp.co.sss.dto.Employee" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" />
		<title>社員管理システム</title>
	</head>
	<body>
		<%@include file="/jsp/common/header.jsp" %>
		<div class="content">
			<input type="hidden" name="${ EmployeeDto.getDisplayType }">
			<article>
				<h3>ログイン画面</h3>
				<div class="form">
					<p></p>
<%-- 					<c:if test="${ '' == employee.empName }">
						<div>職員が存在しません。</div>
					</c:if> --%>
					<c:if test="${ 'success' != employeeDao.displayType }">
						<div>社員IDとパスワードを入力してください。</div>
					</c:if>
					<form action="<%=request.getContextPath() %>/index" method="POST">
						<div class="login_label">社員ID</div>
						<div class="login_input">
							<input type="text" name="empId">
						</div>
						<div class="login_label">パスワード</div>
						<div class="login_input">
							<input type="password" name="empPass">
						</div>
						<div class="login_label"></div>
						<div class="login_input">
							<input type="submit" value="ログイン">
						</div>
					</form>
				</div>
			</article>
		</div>	
		<%@include file="/jsp/common/footer.jsp" %>
	</body>
</html>
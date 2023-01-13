<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jp.co.sss.dto.Employee" %>
<%@ page import="jp.co.sss.dto.Department" %>
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
			<aside>
				<div class="title">社員名検索</div>
				<div class="form">
					<form action="">
						<input type="text" name="empId">
						<input type="submit" value="検索">
					</form>
				</div>
				<div class="title">部署名検索</div>
				<div class="form">
					<form action="">
						<select name="deptId">
							<option value="1">営業部</option>
							<option value="2">経理部</option>
							<option value="3">総務部</option>
						</select>
						<input type="submit" value="検索">
					</form>
				</div>
			</aside>
			<article>
				<h3>社員一覧画面</h3>
				<div class="regist_link">
					<a href="./jsp/regist/regist_input.jsp">新規社員登録</a>
				</div>
				<table class="emp_list_table">
					<tbody>
						<tr>
							<th class="emp_id">社員ID</th>
							<th class="emp_name">社員名</th>
							<th class="gender">性別</th>
							<th class="address">住所</th>
							<th class="birthday">生年月日</th>
							<th class="authority">権限</th>
							<th class="dept_name">部署名</th>
							<th class="button" colspan="2">操作</th>
						</tr>
						<c:forEach var="employee" items="${ employeeList }">
							<tr>
								<td>${ employee.empId }</td>
								<td>${ employee.empName }</td>
								<td>${ employee.gender }</td>
								<td>${ employee.address }</td>
								<td>${ employee.birthday }</td>
								<td>${ employee.authority }</td>
								<td>${ employee.department.deptName }</td>
								<td class="button">
									<form action="<%=request.getContextPath() %>/update_input" method="GET">
										<input type="hidden" name="empid" value="${ employee.empId }">
										<input type="submit" value="変更">
									</form>
								</td>
								<td class="button">
									<form action="<%=request.getContextPath() %>/delete_input" method="GET">
										<input type="hidden" name="empid" value="${ employee.empId }">
										<input type="submit" value="削除">
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</article>
		</div>	
		<%@include file="/jsp/common/footer.jsp" %>
	</body>
</html>
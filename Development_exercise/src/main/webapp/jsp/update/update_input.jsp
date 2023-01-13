<%@page import="jp.co.sss.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<h3>社員変更入力画面</h3>
				<div class="update">
					<form action="<%=request.getContextPath() %>/update_check" method="GET">
						<div class="form">
							<div class="label">パスワード：</div>
							<div class="input">
								<input type="password" name="empPass" value="${ employee.empPass }">
							</div>
						</div>
						<div class="form">
							<div class="label">社員名：</div>
							<div class="input">
								<input type="text" name="empName" value="${ employee.empName }">
							</div>
						</div>
						<div class="form">
							<div class="label">性別：</div>
							<div class="input">
								<input type="radio" name="gender" value="1">
								男性&nbsp;
								<input type="radio" name="gender" value="2">
								女性
								<%
									// TODO 条件分岐処理記述
									if ("2".equals("${ employee.gender }")) {
								%>
								<div>aaa</div>
								<%
									} else {
								%>
								<div>bbb</div>
								<%
									}
								%>
							</div>
						</div>
						<div class="form">
							<div class="label">住所：</div>
							<div class="input">
								<input type="text" name="address" value="${ employee.address }">
							</div>
						</div>
						<div class="form">
							<div class="label">生年月日：</div>
							<div class="input">
								<input type="text" name="birthday" value="${ employee.birthday }">
								(YYYY/MM/DD)
							</div>
						</div>
						<div class="form">
							<div class="label">権限：</div>
							<div class="input">
								<input type="radio" name="authority" value="1">
								一般&nbsp;&nbsp;
								<input type="radio" name="authority" value="2" checked="checked">
								管理者
							</div>
						</div>
						<div class="form">
							<div class="label">部署名：</div>
							<div class="input">
								<select name="deptid">
									<option value="1">営業部</option>
									<option value="2">経理部</option>
									<option value="3">総務部</option>
								</select>
							</div>
						</div>
						<div class="form">
							<div class="label"></div>
							<div class="input">
								<input type="hidden" name="empId">
								<input type="submit" value="変更">
							</div>
						</div>
					</form>
					<form action="<%=request.getContextPath() %>/index" method="POST">
						<div class="form">	
							<div class="label"></div>
							<div class="input">
								<input type="hidden" name="empId">
								<input type="submit" value="戻る">
							</div>
						</div>
					</form>
				</div>
			</article>
		</div>	
		<%@include file="/jsp/common/footer.jsp" %>
	</body>
</html>
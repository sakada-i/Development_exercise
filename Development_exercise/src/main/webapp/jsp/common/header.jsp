<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<div class="content">
		<div class="title">社員管理システム</div>
		<% // TODO:セッションが存在しない場合は表示しない %>
		<c:if test="${ session.getAttribute('empName') != '' }">
			<div class="user_info">
			ようこそ、
				<a href="/update_input.jsp"><%= session.getAttribute("empName") %></a>
			さん | 
				<a href="/index.jsp">ログアウト</a>
			</div>
		</c:if>
	</div>
</header>
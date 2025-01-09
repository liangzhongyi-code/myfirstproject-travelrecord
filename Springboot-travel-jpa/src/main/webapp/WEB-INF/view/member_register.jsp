<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>會員註冊</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/css/buttons.css">
	</head>
	<body>
		<!-- menu bar include -->
		<%@ include file="/WEB-INF/view/menu.jspf" %>
		
		<!-- body content -->
		<div style="padding: 15px">
			<!-- 員工註冊 -->
			<form class="pure-form" method="post" action="/employee/register">
			    會員姓名: <input name="username" required="required" /> <p />
			    登入密碼: <input name="password" required="required" /> <p />
			    出遊花費: <input name="costAmount" value="10000" min="10000" max="100000000" required="required"/> <p />
			    出生日期: <input name="birthday" type="date" required="required" /> <p />
			    會員國籍: <input name="address"required="required"/> <p />
			    <button type="submit">新增</button>
			</form>
		</div>
	</body>
</html>
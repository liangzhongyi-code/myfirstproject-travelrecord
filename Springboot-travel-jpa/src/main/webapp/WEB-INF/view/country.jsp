<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>國家資訊</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/css/buttons.css">
	</head>
	<body>
		<!-- menu bar include -->
		<%@ include file="/WEB-INF/view/menu.jspf" %>
		
		<!-- body content -->
		<div style="padding: 15px">
			<!-- 專案工作 -->
			<sp:form class="pure-form" modelAttribute="countryDTO" method="post" action="/travelrecord/country">
			    國家名稱: <sp:input path="countryname" /> <p />
			    <button type="submit">新增</button>
			</sp:form>
			<!-- 專案列表 -->
			<table class="pure-table pure-table-bordered">
				<thead>
					<tr>
						<th>ID</th><th>國家名稱</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="country" items="${ countriesDTOs }">
						<tr>
							<td>${ country.id }</td>
							<td>${ country.countryname }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>
<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>      
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Members</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/css/buttons.css">
	</head>
	<body>
		<!-- menu bar include -->
		<%@ include file="/WEB-INF/view/menu.jspf" %>
		<!-- body content -->
		<div style="padding: 15px">
			
			<table class="pure-table pure-table-bordered">
				<thead>
					<tr>
						<th>編號</th><th>姓名</th><th>國籍</th><th>生日</th>
						<th>花費</th><th>出遊地點</th><th>出遊時間</th>
					</tr>
				</thead>
				<tbody>
					<!-- 員工資料列表 -->
					<c:forEach var="membersDTO" items="${ membersDTOs }">
						<tr>
							<td>${ membersDTO.id }</td>
							<td>${ membersDTO.membername }</td>
							<td>${ membersDTO.address }</td>
							<td>${ membersDTO.birthday }</td>
							<td align="right">
								<fmt:formatNumber var="amount" value="${membersDTO.cost.amount}" pattern="#,###" />
								$${amount}
								
							</td>
							<td>
								<table class="pure-table">
									<c:forEach var="countryDTO" items="${ membersDTO.countries }"> 
										<td>${ countryDTO.countryname }</td>
									</c:forEach>
								</table>
								<!-- 判斷登入者 -->
								<c:if test="${ sessionScope.membersDTO.id eq membersDTO.id }">
									<a href="/members/country" class="button-success pure-button">修改</a>
								</c:if>
							</td>
							<td>
								<table>
									<c:forEach var="traveltimeDTO" items="${ membersDTO.traveltimes }">
										<tr>
											<td>${ traveltimeDTO.airline }</td>
											<td>${ traveltimeDTO.startDate } ~ ${ traveltimeDTO.endDate }</td>
										</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
						
					</c:forEach>
				</tbody>
			</table>
			
		</div>
	</body>
</html>
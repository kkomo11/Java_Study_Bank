<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List Page</h1>

	
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
			</tr>
		</thead>
		<tbody>
		<!-- for(int i=0; i<=10; i++) 과 동일  step은 증가량 조절 step은 0이하값 불가능-->
	<!--  	<c:forEach begin="0" end="10" var="i" step="2">
			<h3>${pageScope.i}</h3>
		</c:forEach> -->
		
		<c:forEach items="${requestScope.search}" var="dto">
			<tr>
				<td>${pageScope.dto.id}</td>
				<td>${pageScope.dto.name}</td>
				<td>${pageScope.dto.email}</td>
				<td>${pageScope.dto.phone}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
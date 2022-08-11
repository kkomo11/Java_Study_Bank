<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- /book/list -->
	
	<table border="1">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var = "dto">
			
				<tr>
					<td><a href="detail?bookNum=${dto.bookNum}">${dto.bookName}</a></td>
					<td>${dto.bookRate}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
	<a href="add">상품 등록</a>
</body>
</html>
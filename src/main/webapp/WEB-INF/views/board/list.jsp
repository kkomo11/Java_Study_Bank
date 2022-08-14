<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board List Page</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>No</th>
				<th>Title</th>
				<th>Id</th>
				<th>Date</th>
				<th>Hit</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.no}</td>
					<td><a href="detail.iu?no=${dto.no}">${dto.title}</a></td>
					<td>${dto.id}</td>
					<td>${dto.writeDate}</td>
					<td>${dto.hit}</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${member ne null}">
		<a href="add.iu">write</a>
	</c:if>
</body>
</html>
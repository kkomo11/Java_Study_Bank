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
	<h1>Board Detail Page</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>No</th>
				<th>ID</th>
				<th>Date</th>
				<th>Hit</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${detail.no}</td>
				<td>${detail.id}</td>
				<td>${detail.writeDate}</td>
				<td>${detail.hit}</td>
			</tr>
		</tbody>
	</table>
	
	<div>
		<p>제목 	${detail.title}</p>
		<p>${detail.contents}</p>
	</div>
	<div>
		<c:if test="${detail.id eq member.id}">
			<a href="update.iu?no=${detail.no}">수정</a>
			<a href="delete.iu?no=${detail.no}">삭제</a>
		</c:if>
	</div>
	
	
</body>
</html>
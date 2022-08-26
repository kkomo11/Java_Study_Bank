<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-8 mt-5">
		<h1>${board} Page</h1>
		<a href="list.iu">리스트 보기</a>
		<table border="1" class="table table-striped">
			<thead>
				<tr>
					<th>Num</th>
					<th>Title</th>
					<th>Writer</th>
					<th>RegDate</th>
					<th>Contents</th>
					<th>Hit</th>
				</tr>
			</thead>
				
			<tbody>
				<tr>
					<td>${detail.num}</td>
					<td>${detail.title}</td>
					<td>${detail.writer}</td>
					<td>${detail.regDate}</td>
					<td>${detail.contents}</td>
					<td>${detail.hit}</td>
				</tr>
			</tbody>
		</table>
		<c:if test="${member.id eq detail.writer}">
			<a href="update.iu?num=${detail.num}">수정</a>
			<a href="delete.iu?num=${detail.num}">삭제</a>
		</c:if>
		<c:if test="${member ne null and board == 'QnA'}">
			<a href="reply.iu?num=${detail.num}" class="btn btn-dark" style="float:right;">Reply</a>
		</c:if>
	</section>	
	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
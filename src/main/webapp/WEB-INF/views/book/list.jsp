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
	<!-- /book/list -->
	<section class="container-fluid container-lg-8 mt-3">
		<table border="1" class="table table-striped">
			<thead>
				<tr>
					<th>Name</th><th>Rate</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var = "dto">
				
					<tr>
						<td><a href="detail.iu?bookNum=${dto.bookNum}">${dto.bookName}</a></td>
						<td>${dto.bookRate}</td>
					</tr>
				</c:forEach>
	
			</tbody>
		</table>
		
		<a href="add.iu">상품 등록</a>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
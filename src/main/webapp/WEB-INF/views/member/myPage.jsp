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
		<div class="row">
			<table border="1" class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Phone</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${requestScope.dto.id}</td>
						<td>${dto.name}</td>
						<td>${dto.email}</td>
						<td>${dto.phone}</td>
					</tr>
				</tbody>
			</table>
			
			<img alt="" src="../resources/upload/member/${dto.bankMembersFileDTO.fileName}">
		</div>
		
		<table border="1" class="table table-striped">
			<thead>
				<tr>
					<th>AccountNum</th>
					<th>BookName</th>
					<th>AccountDate</th>
				</tr>
			</thead>
				
			<tbody>
				<c:forEach items="${dto.bankAccountDTOs}" var="dto">
					<tr>
						<td>${pageScope.dto.accountNum}</td>
						<td>${pageScope.dto.bankBookDTO.bookName}</td>
						<td>${pageScope.dto.accountDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
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
	<section class="container-fluid col-lg-8 mt-5">
		<form action="update.iu" method="post">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Number</label>
				<input type="text" class="form-control" name="bookNum" value="${detail.bookNum}" readonly="readonly">
			</div>
			
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Enter Name</label>
				<input type="text" class="form-control" name="bookName" value="${detail.bookName}">
			</div>
			
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Enter Rate</label>
				<input type="text" class="form-control" name="bookRate" value="${detail.bookRate}">
			</div>
			
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Sale</label>
				<input type="text" class="form-control" name="bookSale" value="${detail.bookSale}" readonly="readonly">
			</div>
			
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Enter Contents</label>
				<input type="text" class="form-control" name="bookContents" value="${detail.bookContents}">
			</div>
			
			<button type="submit">수정</button>
		</form>
	</section>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
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
		<form action="add.iu" method="post">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Enter Name</label>
				<input type="text" class="form-control" name="bookName">
			</div>
			<div class="mb-3">
				<label for="inputPassword" class="form-label">Enter Rate</label>
				<input type="text" class="form-control" name="bookRate"></input>
			</div>
			<div class="input-group">
	  			<span class="input-group-text">Enter Infomation</span>
	  			<textarea class="form-control" aria-label="With textarea" name="bookContents"></textarea>
			</div>
			<input type="submit">
		</form>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
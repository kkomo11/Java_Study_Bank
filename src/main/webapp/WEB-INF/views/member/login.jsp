<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-8 mt-5">
		
		<form id="form" action="login.iu" method="post">	
			<div class="mb-3">
				<label for="userName" class="form-label">ID</label>
				<input type="text" class="form-control" name="userName" value="id5" id="userName">
			</div>
			<div class="mb-3">
				<label for="passWord" class="form-label">Enter password</label>
				<input type="password" class="form-control" name="passWord" value="pw5" id="passWord"></input>
			</div>
			<p id="errMsg"></p>
			<div class="col-auto">
				<button type="button" id="btnSubmit" class="btn btn-primary mb-3">Confirm</button>
			</div>
		</form>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
	<script>
		loginCheck();
	</script>
	<script src="/resources/js/member.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
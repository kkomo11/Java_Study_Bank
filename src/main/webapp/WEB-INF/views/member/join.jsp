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
		<form action="join.iu" method="post" enctype="multipart/form-data" id="frmJoin">
			<div>
		        <div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">UserName</label>
					<input type="text" class="form-control" name="userName" id="userName">
					<div id="errUserName"></div>
				</div>
		        <div class="mb-3">
					<label for="inputPassword" class="form-label">Enter password</label>
					<input type="password" class="form-control" name="passWord" id="passWord"></input>
					<div id="errPassWord"></div>
				</div>
		        <div class="mb-3">
					<label for="inputPassword" class="form-label">ReEnter password</label>
					<input type="password" class="form-control" name="rePassWord" id="rePassWord"></input>
					<div id="errRePassWord"></div>
				</div>
		        <div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Name</label>
					<input type="text" class="form-control" name="name" id="name">
					<div id="errName"></div>
				</div>
		        <div class="mb-3">
		        	<label for="exampleFormControlInput1" class="form-label">Email</label>
				  	<input type="email" required class="form-control" name="email" id="email">
					<div id="errEmail"></div>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Phone</label>
					<input type="text" class="form-control" name="phone" id="phone">
					<div id="errPhone"></div>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">File</label>
					<input type="file" class="form-control" name="photo">
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-primary mb-3" id="btnJoin">Confirm</button>
				</div>
		    </div>
		</form>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
	<script src="/resources/js/member.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script>
		joinCheck();
	</script>
</body>
</html>
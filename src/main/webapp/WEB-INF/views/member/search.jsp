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
	<section class="container-fluid container-lg-8">
		<div class="row">
			<form class="row g-3" action="search.iu" method="post">
  				<div class="col-auto">
    				<label for="staticEmail2" class="visually-hidden">Search</label>
    				<input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="Search">
  				</div>
  				<div class="col-auto">
				    <input type="text" class="form-control" name="search">
  				</div>
				 <div class="col-auto">
				    <button type="submit" class="btn btn-primary mb-3">Search</button>
				 </div>
			</form>
		</div>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
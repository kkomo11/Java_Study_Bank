<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <!-- jquery -->
 <script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
 <!-- bootStrap -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
 <!-- include summernote css/js-->
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-8 mt-5">
		<h1>${board} Page</h1>
		<form action="add.iu" method="post" enctype="multipart/form-data">
			<input type="hidden" value="${member.id}" name="writer"> 
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Enter Title</label>
				<input type="text" class="form-control" name="title">
			</div>
			<div class="input-group">
	  			<span class="input-group-text">Enter Contents</span>
	  			<textarea class="form-control" aria-label="With textarea" name="contents" rows=7 id="contents"></textarea>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">File</label>
				<input type="file" class="form-control" name="files">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">File</label>
				<input type="file" class="form-control" name="files">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">File</label>
				<input type="file" class="form-control" name="files">
			</div>
			<input type="submit">
		</form>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>
	<!-- BootStrap -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$("#contents").summernote();
	</script>
</body>
</html>
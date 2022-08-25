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
	<section class="container-fluid container-lg-6 mt-3">
		<h1 class="alian-center">${board} Page</h1>
		<table border="1" class="table table-striped">
			<thead>
				<tr>
					<th>Num</th>
					<th>Title</th>
					<th>Writer</th>
					<th>RegDate</th>
					<th>Hit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var = "dto">
				
					<tr>
						<td>${dto.num}</td>
						<td><a href="detail.iu?num=${dto.num}">${dto.title}</a></td>
						<td>${dto.writer}</td>
						<td>${dto.regDate}</td>
						<td>${dto.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${not empty member}">
			<a href="add.iu">글 작성</a>
		</c:if>
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		  <c:if test="${pager.pre}">
		    <li class="page-item">
		   	  <a class="page-link" href="list.iu?page=${pager.startNum-1}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		  </c:if>
		    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		    	<li class="page-item"><a class="page-link" href="list.iu?page=${i}">${i}</a></li>
		    </c:forEach>
		    <li class="page-item ${pager.next?'':'disabled'}">
			  <a class="page-link" href="list.iu?page=${pager.lastNum+1}" aria-label="Next">
			    <span aria-hidden="true">&raquo;</span>
			  </a>
			</li>
		  </ul>
		</nav>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>

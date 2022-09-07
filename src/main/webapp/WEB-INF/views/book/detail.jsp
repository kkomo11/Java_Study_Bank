<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<section class="container-fluid col-lg-8 mt-5">
		<c:import url="../template/header.jsp"></c:import>
		<!-- 상대경로 -->
		<a href="../member/login.iu">Login</a>
		<!-- 절대경로 -->
		<a href="/member/join.iu">Join</a>
	<%-- 
		<% 
		// 요청이 발생하면 생성, 응답이 나가면 소멸 : RequestScope
		BankBookDTO dto = (BankBookDTO) request.getAttribute("detail"); 
		%>
	--%>
		
		<a href="list.iu">리스트 보기</a>
		
		<table border="1" class="table table-striped">
			<thead>
				<tr>
					<th>Num</th>
					<th>Name</th>
					<th>Rate</th>
					<th>Sale</th>
					<th>Contents</th>
				</tr>
			</thead>
				
			<tbody>
				<tr>
					<td>${requestScope.detail.getBookNum()}</td>
					<td>${requestScope.detail.bookName}</td>
					<td>${detail.bookRate}</td>
					<td>${detail.bookSale}</td>
					<td>${detail.bookContents}</td>
				</tr>
			</tbody>
		</table>
		<a href="update.iu?bookNum=${detail.bookNum}" class="btn btn-primary">수정</a>
		<a href="delete.iu?bookNum=${detail.bookNum}" class="btn btn-danger">삭제</a>
		<c:if test="${member ne null}">
			<a href="/account/add.iu?bookNum=${detail.bookNum}">가입</a>
		</c:if>

		<div class="row">
			<div class="mb-3">
				<label for="writer" class="form-label">writer</label>
				<input type="text" class="form-control" id="writer">
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">Example textarea</label>
				<textarea class="form-control" id="contents" rows="3"></textarea>
			</div>
			<div class="mb-3">
				<button type="button" id="btnCommentAdd" data-bookNum="${detail.bookNum}">댓글 작성</button>
			</div>
		</div>

		<div>
			<table id="commentList" class="table"></table>
		</div>
		<button id="more" class="btn btn-danger disabled">더보기</button>

		<div>
			<button type="button" style="display: none;" id="up" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">Open modal for @getbootstrap</button>
			<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Update</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form>
					<div class="mb-3">
						<label for="recipient-name" class="col-form-label">Writer:</label>
						<input type="text" class="form-control" id="recipient-name">
					</div>
					<div class="mb-3">
						<label for="message-text" class="col-form-label">Contents:</label>
						<textarea class="form-control" id="message-text"></textarea>
					</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Send message</button>
				</div>
				</div>
			</div>
			</div>
		</div>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
	<script src="/resources/js/bookComment.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
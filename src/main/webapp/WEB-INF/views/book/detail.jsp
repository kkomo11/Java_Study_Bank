<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail</h1>
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
	
	<table border="1">
		<thead>
			<tr>
				<th>Num</th><th>Name</th><th>Rate</th><th>Sale</th>
			</tr>
		</thead>
			
		<tbody>
			<tr>
				<td>${requestScope.detail.getBookNum()}</td>
				<td>${requestScope.detail.bookName}</td>
				<td>${detail.bookRate}</td>
				<td>${detail.bookSale}</td>
			</tr>
		</tbody>
	</table>
	<a href="update.iu?bookNum=${detail.bookNum}">수정</a>
	<a href="delete.iu?bookNum=${detail.bookNum}">삭제</a>
	<c:if test="${member ne null}">
		<a href="/account/add.iu?bookNum=${detail.bookNum}">가입</a>
	</c:if>
</body>
</html>
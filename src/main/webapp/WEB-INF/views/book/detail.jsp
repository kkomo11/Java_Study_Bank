<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail</h1>
	<!-- 상대경로 -->
	<a href="../member/login">Login</a>
	<!-- 절대경로 -->
	<a href="/member/join">Join</a>
	<% BankBookDTO dto = (BankBookDTO) request.getAttribute("detail"); %>
	
	<%if(dto != null) { %>
		<table border="1">
			<thead>
				<tr>
					<th>Num</th><th>Name</th><th>Rate</th><th>Sale</th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td><%= dto.getBookNum() %></td>
					<td><%= dto.getBookName() %></td>
					<td><%= dto.getBookRate() %></td>
					<td>
						<% if(dto.getBooksale() == 1) { %> 
							판매중
						<%} else { %>
							비매품
						<%} %>
					</td>			
				</tr>
			</tbody>
		</table>
	<%} else {%>
		<h3>Not Found</h3>
	<%} %>
</body>
</html>
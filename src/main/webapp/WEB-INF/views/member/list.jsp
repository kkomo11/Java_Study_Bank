<%@page import="com.iu.start.bankmembers.BankMembersDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List Page</h1>
	<% ArrayList<BankMembersDTO> arr = (ArrayList<BankMembersDTO>) request.getAttribute("search"); %>
	
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				
			</tr>
		</thead>
		<%for(BankMembersDTO dto : arr) { %>
			<tr>
				<td><%= dto.getId() %></td>
				<td><%= dto.getName() %></td>
				<td><%= dto.getEmail() %></td>
				<td><%= dto.getPhone() %></td>
			</tr>	
		<%} %>
	</table>
</body>
</html>
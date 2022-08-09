<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.iu.start.bankbook.BankBookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- /book/list -->
	<!-- /book/detail jsp:detail.jsp 링크는 상대경로 -->
	<a href="./detail">Detail</a>
	<% ArrayList<BankBookDTO> arr = (ArrayList<BankBookDTO>) request.getAttribute("list"); %>
	
	<table border="1">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th>
			</tr>
		</thead>
		<tbody>
			<% for(BankBookDTO dto : arr) { %>	
				<tr>
					<td><a href="detail?bookNum=<%=dto.getBookNum()%>"><%= dto.getBookName() %></a></td>
					<td><%= dto.getBookRate() %> </td>
				</tr>
			<% }%>
		</tbody>
	</table>
</body>
</html>
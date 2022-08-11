<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>
<% System.out.println(request.getAttribute("member")); %>
<P>  The time on the server is ${serverTime}. </P>
<c:if test="${member eq null}">
	<a href="./member/login">Login</a>
	<a href="./member/join">Join</a>
</c:if>

<c:if test="${member ne null}">
	<a href="#">Logout</a>
	<a href="#">MyPage</a>
</c:if>

<a href="./member/search">Search</a>
<a href="./book/list">List</a>
</body>
</html>
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

<P>  The time on the server is ${serverTime}. </P>
<c:if test="${sessionScope.member eq null}">
	<a href="./member/login.iu">Login</a>
	<a href="./member/join.iu">Join</a>
</c:if>

<c:if test="${member ne null}">
	<h3>${member.name}님 환영합니다.</h3>
	<a href="./member/logout.iu">Logout</a>
	<a href="#">MyPage</a>
</c:if>

<a href="./member/search.iu">Search</a>
<a href="./book/list.iu?member=${member}">List</a>
<a href="./board/list.iu">BoardList</a>
</body>
</html>
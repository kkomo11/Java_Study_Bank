<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
	<form action="join" method="post">
	<div>
        <h3>회원가입</h3>
        <p>ID</p>
        <input type="text" name="id">
        <p>PW</p>
        <input type="password" name="pw">
        <p>Name</p>
        <input type="text" name="name">
        <p>Email</p>
        <input type="text" name="email">
        <p>Phone</p>
        <input type="text" name="phone">
    </div>

    <div>
        <br>
        <input type="submit" value="회원가입">
    </div>
	</form>
</body>
</html>
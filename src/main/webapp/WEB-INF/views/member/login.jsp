<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	<h3>ID 로그인</h3>
	<form action="login.iu" method="post">	
    <div>
        <p>ID</p>
        <input type="text" name="id" value="id4">
        <p>PW</p>
        <input type="password" name="pw" value="pw4">
        <br>
        <input type="checkbox" name="cb"> 로그인 상태 유지
    </div>

    <div>
        <input type="submit" value="로그인">
    </div>
	</form>
</body>
</html>
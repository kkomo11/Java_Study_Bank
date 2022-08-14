<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Writing Update Page</h1>
	
	<form action="update.iu" method="post">
		<input type="hidden" name="no" value="${no}">
		작성자 <input type="text" name="id" value="${member.id}" readonly="readonly">
		제목 <input type="text" name="title">
		<br><br>
		
		<textarea rows="10" cols="50" name="contents"></textarea>
		<button type="submit">저장</button>
	</form>
</body>
</html>
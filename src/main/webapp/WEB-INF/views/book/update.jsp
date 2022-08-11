<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Page</h1>
	
	<form action="update", method="post">
		<div>
			Num : <input type="text" name="bookNum" value="${detail.bookNum}" readonly="readonly">
		</div>
		<div>
			Name : <input type="text" name="bookName" value="${detail.bookName}">
		</div>
		<div>
			Rate : <input type="text" name="bookRate" value="${detail.bookRate}">
		</div>
		<div>
			Sale : <input type="text" value="${detail.bookSale}" readonly="readonly">
		</div>
		<button type="submit">수정</button>
	</form>
</body>
</html>
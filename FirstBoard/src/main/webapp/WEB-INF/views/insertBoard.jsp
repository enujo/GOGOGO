<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>글 작성</title>
</head>
<body>
	<form action="insertBoard" method="post" >
		<div>
			<input name="boardTitle" type="text">
		</div>
		<div>
			<textarea name="boardContent" rows="10" cols="30"></textarea>
		</div>
		<div>
			<input name="boardBT" type="submit" value="작성">
		</div>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>글 수정</title>
</head>
<body>
	<form action="<c:url value='updateBoard'/>" method="POST" >
		<div>
			글번호 : <input name="boardNo" type="text" value="${board.boardNo}" readonly="readonly">
		</div>
		<div>
			제목 : <input name="boardTitle" type="text" value="${board.boardTitle }">
		</div>
		<div>
			내용 : <textarea name="boardContent" rows="10" cols="30" >${board.boardContent }</textarea>
		</div>
		<div>
			작성일 : <input type="text" value="${board.boardDate }" readonly="readonly">
		</div>
		<div>
			<input type="submit" value="수정완료">
		</div>
	</form>
</body>
</html>
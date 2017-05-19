<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>글 내용</title>
</head>
<body>
	<div>
		제목 : ${board.boardTitle }
	</div>
	<div>
		내용 : ${board.boardContent }
	</div>
	<div>
		날짜 : ${board.boardDate }
	</div>
	<div>
		<a href="<c:url value='updateBoard?boardNo=${board.boardNo}'/>">
			수정
		</a>
		<a href="<c:url value='boardDelete?boardNo=${board.boardNo}'/>">
			삭제
		</a>
	</div>
</body>
</html>
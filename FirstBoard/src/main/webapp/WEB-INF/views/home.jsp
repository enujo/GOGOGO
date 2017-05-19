<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		안녕하세요
	</h1>
	<div>
		글 작성 : <c:url value="insertBoard"/>
	</div>
	<div>
		글 목록 : <c:url value="boardList"/>
	</div>
</body>
</html>

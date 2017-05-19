<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>글 목록</title>
</head>
<body>
<div>
	<h3>LIST</h3>
</div>
<div>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${boardList}" var="list"> 
				<tr>
					<td>${list.boardNo}</td>
					<td>
						<a href = "<c:url value= 'boardDetail?boardNo=${list.boardNo }' />">
							${list.boardTitle}
						</a>
					</td>
					<td>${list.boardContent}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div>
	<c:if test="${startPage>1}">
		<a href="<c:url value='boardList?currentPage=${startPage-pageSize}'/>">
			prev
		</a>
	</c:if>
	
	<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
		<a href="<c:url value='boardList?currentPage=${i}'/>">
			${i}
		</a>
	</c:forEach>
	<c:if test="${endPage ne lastPage}">
		<a href="<c:url value='mileageList?currentPage=${startPage+pageSize}'/>">
			next
		</a>
	</c:if>
</div>
</body>
</html>
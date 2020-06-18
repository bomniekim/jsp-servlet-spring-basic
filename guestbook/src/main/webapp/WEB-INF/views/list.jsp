<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<h1>방명록</h1>
 	<br /> 방명록 전체 수 : ${count} / 방문 횟수 : ${cookieCnt}
 	<br />
 	<br />
	<c:forEach items="${list}" var="guestbook">
		${guestbook.id} <br />
		${guestbook.name} <br />
		${guestbook.content} <br />
		${guestbook.regDate} <br />
		<c:if test="${sessionScope.isAdmin == 'true'}"><a href="delete?id=${guestbook.id}">삭제</a><br><br></c:if>
	</c:forEach>
	<br />
	
	<!-- status.index : 0 부터 레코드 순서 시작 -->
	<c:forEach items="${pageStartList}" var="pageStart" varStatus="status">
		<a href="list?start=${pageStart}">${status.index + 1}</a>
		&nbsp;&nbsp;
	</c:forEach>
	
	<br />
	<br />
	<form action="write" method="post">
		<input type="text" name="name" placeholder="name" /><br />
		<textarea name="content" cols="60" rows="6"></textarea><br />
		<input type="submit" value="Save" />
	</form>
</body>
</html>
 
	
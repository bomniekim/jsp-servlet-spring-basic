<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guess lucky Number</title>
</head>
<body>
	<h1>Guess Number!</h1>
	<h3>${msg}</h3>
	<!-- 숫자를 맞추면 session 의 count 가 삭제되므로 null -->
	<!-- 그러한 경우에는 화면에 보여지지 않도록 c:if 사용 -->
	<c:if test="${sessionScope.count != null}">
		<form action="guess" method="get">
			Guess lucky number from 1 to 100. <br />
			<input type="text" name="number"> <br />
			<input type="submit" value="check">
		</form>
	</c:if>
	<a href="guess">Try Again</a>
</body>
</html>
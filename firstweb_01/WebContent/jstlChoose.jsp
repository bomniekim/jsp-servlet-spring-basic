<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setAttribute("score", 92);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test=" ${ score >= 90}"> You got A </c:when>
	<c:when test=" ${ score >= 80}"> You got B </c:when>
	<c:when test=" ${ score >= 70}"> You got C </c:when>
	<c:when test=" ${ score >= 60}"> You got D </c:when>
	<c:otherwise> F! </c:otherwise>
</c:choose>

</body>
</html>
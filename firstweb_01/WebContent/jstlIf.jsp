<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <%
	// 1) jsp 문법
	request.setAttribute("n", 10);
%> --%>

<!-- 2) JSTL 표기 -->
<c:set var="n" scope="request" value="10"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 조건 부분은 el로 표기 -->
<c:if test="${n==0 }"> n의 값은 0입니다. </c:if>
<c:if test="${n==10 }"> n의 값은 10입니다. </c:if>

</body>
</html>
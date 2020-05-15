<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="script" value="<script type='text/javascript'>alert(1);</script>" />


<!-- value : jspWriter 에 출력할 값  -->
<!-- escapeXml = "true" : 값을 모두 문자열로 인식 (디폴트 값 : true) -->
<c:out value="${script }" escapeXml="false"></c:out>
</body>
</html>
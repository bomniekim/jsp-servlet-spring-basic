<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	// scriptlet
	pageContext.setAttribute("page", "page scope value");
	request.setAttribute("request", "request scope value");
	session.setAttribute("session", "session scope value");
	application.setAttribute("application", "application scope value");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 기존 jsp 문법의 표현식 --%>
<%= pageContext.getAttribute("page")%><br>

<%-- el 표기법 --%>
	pageContext.getAttribute("page") : ${pageScope.page} <br />
	request.getAttribute("request") : ${requestScope.request} <br />
	session.getAttribute("session") : ${sessionScope.session} <br />
	application.getAttribute("application") : ${applicationScope.application} <br />
	
	<hr>
	<%-- 각각의 scope에 저장되어 있는 값들의 이이 중복되지 않는 경우에는 scope 생략 가능 --%>
	<%-- but 명시적으로 쓰는 것이 좋음 --%>
	pageContext.getAttribute("page") : ${page} <br />
	request.getAttribute("request") : ${request} <br />
	session.getAttribute("session") : ${session} <br />
	application.getAttribute("application") : ${application} <br />



</body>
</html>
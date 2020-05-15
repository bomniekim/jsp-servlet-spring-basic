<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--  default 값은 false --%>
<%-- <%@ page isELIgnored ="true"%> --%>

<%
request.setAttribute("value", 10);
request.setAttribute("value2", true);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
value : ${value } <br>
value + 5 : ${value + 5 } <br>
value - 5 : ${value - 5 } <br>
value * 5 : ${value * 5 } <br>
value / 5 : ${value div 5 } <br>

<hr>

value > 5 : ${value > 5 } <br>
value < 5 : ${value < 5 } <br>
value >= 5 : ${value >= 10 } <br>
value <= 5 : ${value <= 10} <br>

<hr>

value2 : ${value2 } <br>
!value2 : ${!value2 } <br>
</body>
</html>
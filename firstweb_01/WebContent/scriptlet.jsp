<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for (int i=1; i<=5; i++) {
%>
	<H<%=i%>>코딩을 열심히 하자 </H<%=i%>>
<%		
	}
	// 응답결과에 값을 표현하고 싶은 경우에는 표현식 안에 
%>

</body>
</html>
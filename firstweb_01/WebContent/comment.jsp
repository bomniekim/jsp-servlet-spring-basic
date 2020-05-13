<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- jsp의 주석 표현입니다.
	 여려 줄 처리도 가능합니다.
	 3가지의 주석 표현이 가능하지만 어떻게 처리되는 지 구별해야 합니다.
 --%>
 <!-- html 주석 표현입니다. 화면에 그대로 출력됩니다. -->
<%
// java 주석 표현입니다. 
	for (int i=1; i<=5; i++) {
%>
	<h<%=i%>>코딩을 열심히 하자 </h<%=i%>>
<%		
	}
	// 응답결과에 값을 표현하고 싶은 경우에는 표현식 안에 
%>

</body>
</html>
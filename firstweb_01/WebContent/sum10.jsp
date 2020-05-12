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
// scriptlet : 자바 코드를 입력할 수 있는 부분
	int total = 0;
	for (int i = 1; i <= 10; i++) {
		total = total + i;
	}
%>

1부터 10까지의 합 : <%=total%>
<!--  out.println(total); 과 같은 결과 --> 

<!-- 모든 jsp는 서블릿으로 바뀌어서 동작, % 같은 기호(지시자)는 서블릿으로 바뀔 때 어떻게 바뀌는지를 알려주는 기호 -->
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Life cycle JSP

<!-- scriptlet : 서블릿의 service() 메소드에 추가되는 Java 코드 -->
<%
	System.out.println("jspService()");
%>

<!-- 선언식 : 서블릿의 service() 메소드 외부에 메소드를 선언하는 Java 코드  -->
<%!
	public void jspInit(){
		System.out.println("jspInit()!");
	}

	public void jspDestroy(){
		System.out.println("jspDestroy()");
	}
%>
</body>
</html>
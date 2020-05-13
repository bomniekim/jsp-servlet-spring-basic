<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// response 내장객체 
	response.sendRedirect("redirect02.jsp");

	// 서버로부터 응답코드 302(리다이렉트) 요청 받아 redirect02.jsp를 요청하면 주소창이 바뀌면서 페이지가 보여짐
	// 즉 요청은 2번 이루어짐
%>

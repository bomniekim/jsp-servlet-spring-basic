<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%-- 지시자를 통해 태그 라이브러리 사용 설정 --%>
<%-- prefix를 지정하여 누구의 태그인지 알 수 있게 --%>
<%-- uri :uri 에서 지정한 JSTL 을 사용하겠다고 설정 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="value1" scope="request" value="kim"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
family name: ${value1 } <br>
<c:remove var="value1" scope="request"></c:remove>
family name: ${value1 } <br>

</body>
</html>
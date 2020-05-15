<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="http://localhost:9130/firstweb_01/jstlImportSample.jsp" var="urlValue" scope="request"></c:import>
<!-- var : url을 읽어드린 후 그 값을 담을 변수  -->

<!-- c:param name="name" value="value" : 지정한 url 에 연결할 때 전송할 파라미터값 (url?name=value와 같음) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${urlValue }
</body>
</html>
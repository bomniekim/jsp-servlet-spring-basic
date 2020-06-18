<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload form</title>
</head>
<body>
<h1>Upload Form</h1>
<br/>
 <form method="post" action="upload" enctype="multipart/form-data">
	 <!-- 파일 업로드를 위해선 반드시 method=post & enctype=multipart/form-data 으로 지정  -->

    file : <input type="file" name="file"><br/>
        <input type="submit" value="올리기">
 </form>    
</body>
</html>   
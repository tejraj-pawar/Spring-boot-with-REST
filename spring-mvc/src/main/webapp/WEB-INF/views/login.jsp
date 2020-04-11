<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yahoo!!! from JSP</title>
</head>
<body>
<!-- <form action="/login.do" method="post"> -->
 
<form action="/spring-mvc/login" method="post">
<p><font color="red">${errorMessage}</font></p>
Enter your Name: <input type="text" name="name"/>
Enter your Password: <input type="password" name="password"/>
<input type="submit" value="Login"/>
</form>  


</body>
</html>


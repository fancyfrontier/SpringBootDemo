<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>第一個在Spring Boot環境下執行的JSP檔</title>
</head>
<body>
<div align='center'>
   <h2>${helloMessage}</h2>
   <hr>
   
   <a href="<c:url value='/'  />">回首頁</a>
   
</div>
</body>
</html>
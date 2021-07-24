<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/style.css' />
<title>Insert title here</title>
</head>
<body>
<div align='center'>
<h2>會員列表</h2>
<hr>
<table border='1'>
<tr><th>鍵值</th><th>會編</th><th>姓名</th><th>餘額</th><th>生日</th><th>註解</th></tr>
<c:forEach var='member' items='${members123}'>
  <tr>
     <td>${member.pk}</td>
     <td>${member.id}</td>
     <td>${member.name}</td>
     <td>${member.balance}</td>
     <td>${member.birthday}</td>
     <td>${member.extra}</td>
 </tr>    
</c:forEach>
</table>
<hr>
<a href="<c:url value='/'  />">回首頁</a>
</div>
</body>
</html>
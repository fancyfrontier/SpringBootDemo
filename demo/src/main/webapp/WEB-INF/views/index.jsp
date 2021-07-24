<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/style.css' />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align='center'>
		<h2>Spring Boot 範例</h2>
		<hr>
		<a href="<c:url value='/des/sdsd/asa'  />">第一個Spring Boot程式</a><br>
		<a href="<c:url value='/springmvc/members'  />">會員資料列表(SpringMVC)</a><br>
		<hr>
		<a href="<c:url value='/ajax/addMemberForm'  />">新增會員資料(Ajax)</a><br>
		<a href="<c:url value='/ajax/memberForm'  />">會員資料列表(Ajax)</a><br>
		<hr>
		Context Path(上下文路徑): ${pageContext.request.contextPath}<br>
		<hr>
		${myKitty}
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/style.css' />" type="text/css" />
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
window.onload = function(){
	let dataArea = document.getElementById("dataArea");
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "<c:url value='/ajax/members' />");
	xhr.send();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200){
			dataArea.innerHTML = processMemberData(xhr.responseText);
		}
	}
}

function processMemberData(jsonString){
	let members = JSON.parse(jsonString);
	let segment = "<table border='1'>";
	segment += "<tr><th colspan='7'>會員資料列表</th></tr>";
	segment += "<tr><th>會員編號</th><th>姓名</th><th>生日</th><th>餘額</th><th>建檔日期</th><th>總點數</th><th>總金額</th></tr>";
	for(let n = 0 ; n < members.length; n++){
		let member = members[n];
		segment += "<tr>";
		 
		let link = "<a href='" + "<c:url value='/ajax/editForm' />?id=" + member.id + "'>" + member.id + "</a>";
		if (n == 0) {
		   console.log(link);
		}
		segment += "<td>" + link + "</td>";
		segment += "<td>" + member.name + "</td>";
		segment += "<td>" + member.birthday + "</td>";
		segment += "<td>" + member.balance + "</td>";
		segment += "<td>" + member.createTime + "</td>";
		segment += "<td>" + member.totalPoints + "</td>";
		segment += "<td>" + member.totalAmount + "</td>";
		segment += "</tr>";
	}
	segment += "</table>";
	return segment;
}


</script>
</head>
<body>
<div id='dataArea' align='center'>

</div>
<div align='center'>
  <a href="<c:url value='/index' />">回首頁</a>
</div>
</body>
</html>
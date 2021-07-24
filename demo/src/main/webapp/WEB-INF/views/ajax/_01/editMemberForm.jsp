<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href="<c:url value='/css/style.css' />" type="text/css" />
<title>Insert title here</title>
<script>
let sid = "${idid}";
let pk  = 0;
window.onload = function() {
	var divResult = document.getElementById('resultMsg');
	let id 			= document.getElementById("id");
	let name 		= document.getElementById("name");
	let balance 	= document.getElementById("balance");
	let birthday 	= document.getElementById("birthday");
	let sendData 	= document.getElementById("sendData");

	let xhr = new XMLHttpRequest();

	xhr.open("GET", "<c:url value='/ajax/member?id=' />" + sid);
	xhr.send();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200){
			
			let member 		= JSON.parse(xhr.responseText);
			id.value 		= member.id;
			name.value 		= member.name;
			balance.value 	= member.balance;
			birthday.value 	= member.birthday;
			pk = member.pk;
		}
	}
	
	sendData.onclick = function(){
		let idValue = document.getElementById("id").value;
		let nameValue = document.getElementById("name").value;
		let balanceValue = document.getElementById("balance").value;
		let birthdayValue = document.getElementById("birthday").value;
		
		let obj = {
		   "pk": pk,
		   "id": idValue,
		   "name": nameValue,
		   "balance": balanceValue,
		   "birthday": birthdayValue
		};
		
		let xhr2 = new XMLHttpRequest();
		let url = "<c:url value='/members/'  />" + pk;
		console.log(url);
		xhr2.open("PUT", url);
		xhr2.setRequestHeader("Content-Type", "application/json");
		xhr2.send(JSON.stringify(obj));
		xhr2.onreadystatechange = function(){
			if (xhr2.readyState == 4 && xhr2.status == 200){
				let result 		= JSON.parse(xhr2.responseText);
				if (result.fail) {
			 		  divResult.innerHTML = "<font color='red' >"
						+ result.fail + "</font>";
		  		} else if (result.success) {
					divResult.innerHTML = "<font color='GREEN'>"
						+ result.success + "</font>";
		  		}
				
			}
		}
	}
	
}
</script>
</head>
<body>
<div align='center'>
<h3>修改會員資料</h3>
<hr>
<div id='resultMsg' style="height: 18px; font-weight: bold;"></div>
	<br>
	<fieldset style='display: inline-block; width: 820px;'> 
	<legend>修改下列資料</legend>
	<table border='1'>
	<tr height='60'>
		<td width='200'>&nbsp;</td>
		<td width='400'>
			&nbsp;帳號: <input type="text" name="id" id='id'><br>
			<div style='font-size: 10pt; text-align: center;'>
   				<a href='#' id='accountCheck' style='font-size: 10pt;'>檢查帳號</a>
			</div>
		</td>
		<td width='200'>
			<div id='result0c' style="height: 10px;"></div><br>
			<div id='result0s' style="height: 10px;"></div>
		</td>
	</tr>
	<tr height='60'>
		<td width='200'>&nbsp;</td>
		<td width='400'>
			&nbsp;姓名: <input type="text" name="name" id='name'><br>
		</td>
		<td width='200' style="vertical-align:top">
			<div id='result1c' style="height: 10px;"></div><br>
			<div id='result1s' style="height: 10px;"></div>
		</td>	
	</tr>
	<tr height='60'>
		<td width='200'>&nbsp;</td>
		<td width='400'>
			&nbsp;餘額: <input type="text" name="balance" id='balance'><br>
		</td>
		<td width='200' style="vertical-align:top">
			<div id='result2c' style="height: 10px;"></div><br>
			<div id='result2s' style="height: 10px;"></div>
		</td>	
	</tr>
	<tr height='60'>		
		<td width='200'>&nbsp;</td>
		<td width='400'>
			&nbsp;生日: <input type="text" name="birthday" id='birthday' size='24'>
		</td>	
		<td width='200'>
			<div id='result3c' style="height: 10px;"></div><br>
			<div id='result3s' style="height: 10px;"></div>			
		</td>	
	</tr>
	<tr height='50'>		
		<td colspan='3' align='center'><button id='sendData'>送出</button></td>
	</tr>		
			</table>
		</fieldset>
	<hr>	
	<p>	
	<a href="<c:url value='/index'  />">回前頁</a>
<hr>
</div>


</body>
</html>
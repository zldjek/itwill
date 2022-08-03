<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypageInfo.jsp</title>
<script>
	function changeForm(val) {
		if(val == 0) { // 메인페이지
			location.href="#";
		} else if(val == 1) {
			location.href="myInfoUpdate.jsp";
		} else if(val == 2) {
			location.href="myInfoDelete.bo";
		}
	}
</script>
</head>
<body>
	<h1>회원 상세정보</h1>
	<section>
		<table>
			<tr>
			    <td><p>이름</p></td>
			    <td>${member.member_name }</td>
			</tr>
				
			<tr>
				<td>비밀번호</td>
				<td>${member.member_passwd }</td>			
			</tr>
				
			<tr>
				<td>주소</td>
				<td>${member.member_address }</td>
			</tr>
				
			<tr>
				<td>연락처</td>
				<td>${member.member_phone }</td>
			</tr>
				
			<tr>
				<td>이메일</td>
				<td>${member.member_emial }</td>
			</tr>
		</table>
	 <input type="button" value="Home" onclick="changeForm(0)">
	 <input type="button" value="회원정보변경" onclick="changeForm(1)">
	
	
	
	<br><br><br><br><br><br>
	<!-- 회원탈퇴는 맨 밑쪽에 있었으면 합니다! -->
		<div>
	 		<input type="button" value="회원탈퇴" onclick="changeForm(2)"> 
		</div>
	</section>
</body>
</html>
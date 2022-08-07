<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user_info.jsp</title>
</head>
<body>
	<h1>내정보</h1>
	<!-- session 영역에 id를 출력 -->
	<h3>${param.user_id }님 회원상세정보</h3>
	<table>
		<tr>
			<td><p>이름</p></td>
			<td>${param.user_id }</td>
		</tr>

		<tr>
			<td>비밀번호</td>
			<td>$param.user_passwd }</td>
		</tr>

		<tr>
			<td>주소</td>
			<td>${param.user_address }</td>
		</tr>

		<tr>
			<td>연락처</td>
			<td>${param.user_phone }</td>
		</tr>

		<tr>
			<td>이메일</td>
			<td>${param.user_emial }</td>
		</tr>
	</table>
	<input type="button" value="Home" onclick="href='#'">
	<input type="button" value="회원정보변경" onclick="href='user_update.jsp'">



	<br>
	<br>
	<br>
	<!-- 회원탈퇴는 맨 밑쪽에 있었으면 합니다! -->
	<div>
		<input type="button" value="회원탈퇴" onclick="href='user_delete.jsp'">
	</div>
</body>
</html>
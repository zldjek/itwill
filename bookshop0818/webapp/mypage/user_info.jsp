<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
</head>
<body>
	<h1>내정보</h1>
	<!-- session 영역에 id를 출력 -->
	<section>
		<div>
	<h3>${user.user_id }님회원상세정보</h3>
			<table>
				<tr>
					<td><p>이름</p></td>
					<td>${user.user_id }</td>
				</tr>

				<tr>
					<td>비밀번호</td>
					<td>${user.user_passwd }</td>
				</tr>

				<tr>
					<td>주소</td>
					<td>${user.user_address }</td>
				</tr>

				<tr>
					<td>연락처</td>
					<td>${user.user_phone }</td>
				</tr>

				<tr>
					<td>이메일</td>
					<td>${user.user_emial }</td>
				</tr>
			</table>
		</div>
	</section>

	<input type="button" value="mypage" onclick="location.href='Mypage.me'">
	<input type="button" value="회원정보변경"
		onclick="location.href='UserUpdate.me'">
	<br>
	<br>
	<br>
	<!-- 회원탈퇴는 맨 밑쪽에 있었으면 합니다! -->
	<div>
		<input type="button" value="회원탈퇴"
			onclick="location.href='Userdelete.me'">
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보 수정</title>
</head>
<body>
	<section id="userInfoArea">
		<table>
			<tr>
				<td>아이디 :</td>
				<td>${user.user_id }</td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td>${user.user_name}</td>
			</tr>
			<tr>
				<td>연락처 :</td>
				<td>${user.user_phone}</td>
			</tr>
			<tr>
				<td>주소 :</td>
				<td>${user.user_address}</td>
			</tr>
			<tr>
				<td>이메일 주소 :</td>
				<td>${user.user_email}</td>
			</tr>
			<tr>
				<td colspan=2><a href="./Mypage.me">마이페이지로 돌아가기</a></td>
			</tr>
		</table>
	</section>
</body>
</html>
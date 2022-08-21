<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<div>
		<!--헤더<jsp:include page="#"/>-->
	</div>

	<h1>마이페이지</h1>
	<section>
		<div>
			<span>${param.user_id } 님 환영합니다.</span>
			<table border="1">
				<tr>
					<td><b>회원정보확인</b></td>
				</tr>
				<tr>
					<td><a href="UserInfoPro.me">회원정보 조회</a></td>
				</tr>
				<tr>
					<td><a href="UserUpdateForm.me">회원정보 수정</a></td>
				</tr>
				<tr>
					<td><a href="UserDeleteForm.me">회원 탈퇴</a></td>
				</tr>

				<tr>
					<td><b>주문내역확인</b></td>
				</tr>
			</table>
		</div>
	</section>

	<div>
		<!--풋터<jsp:include page="#"/>-->
	</div>
</body>
</html>
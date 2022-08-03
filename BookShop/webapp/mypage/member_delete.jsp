<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>withdrawal.jsp</title>
</head>
<body>
	<h1>회원탈퇴</h1>
	<!-- 탈퇴시 다시 묻습니다. 진심 탈퇴할것인지 주의상황도  -->
	<div>
	꼭 일어보시길 바랍니다!<br>
	회원탈퇴전 주의상황<br>
	1. 회원탈퇴시 기존에 데이터들은 삭제되므로 저희 사이트에서<br>
	   구입 내역 및 입금 포인트도 모두 사라지니 탈퇴전<br>
	   남은금액 출금 포인트 전환을 미리 하시기 바랍니다.<br>
	   꼭 유의 해주시면 감사하겠습니다.
	 </div>
	 
	 <section>
			<form name="deleteForm" action="myInfoDelete.bo?id=${member.member_id }" 
				method="post">
				<table>
					<tr>
						<td>
							<label>비밀번호 : </label>
						</td>
						<td>
							<input name="passwd" type="password">
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value ="회원탈퇴" onclick="href='MyInfoDelete.bo?id=${user.id}'">
							&nbsp;&nbsp;
							<input type ="button" value ="돌아가기" onClick ="href='#'">
						</td>
					</tr>
				</table>
			</form>
	</section>
</body>
</html>
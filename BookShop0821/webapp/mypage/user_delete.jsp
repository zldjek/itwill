<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<script>
	function checkedPasswd(passwd) {
		var passwd = '<%=(String)session.getAttribute("user_passwd")%>';
		if(passwd == "passwd") {
			alert("회원탈퇴 되었습니다.");
			location.href = "#";
		} else if (passwd != "passwd"){
			alert("비밀번호가 맞지않습니다.");
			location.href = "history.back()";
		} else if(passwd == null) {
			alert("비밀번호를 입력하세요.");
			location.href = "#";
		} else {
			alert("고객센터 문의 바랍니다.");
		}
	}

</script>
</head>
<body>
	<h1>회원탈퇴</h1>
	<!-- 탈퇴시 다시 묻습니다. 진심 탈퇴할것인지 주의상황도  -->
	<div>
		꼭 일어보시길 바랍니다!<br> 회원탈퇴전 주의상황<br> 1. 회원탈퇴시 기존에 데이터들은 삭제되므로 저희
		사이트에서<br> 구입 내역 및 입금 포인트도 모두 사라지니 탈퇴전<br> 남은금액 출금 포인트 전환을 미리
		하시기 바랍니다.<br> 꼭 유의 해주시면 감사하겠습니다.
	</div>

	<section>
		<form name="deleteForm"
			action="UserDelete.me?id=${param.user_id }" method="post">

			<table>
				<tr>
					<td><label>비밀번호 : </label></td>
					<td><input type="password" name="passwd" placeholder="비밀번호를 입력해주세요"></td>
				</tr>
				<tr>
					<td><input type="submit" value="회원탈퇴" onclick="checkedPasswd();">
						&nbsp;&nbsp; <input type="button" value="돌아가기" onClick="location.href='#'">
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>
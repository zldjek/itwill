<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="loginFormArea">
		<h1>로그인</h1>
		<form action="./my_page.jsp" method="post">
			<fieldset>
				<table>
					<tr>
						<td class="td_left"><label for="id">아이디 : </label></td>
						<td class="td_right"><input type="text" name="user_id" id="id" />
						</td>
					</tr>
					<tr>
						<td class="td_left"><label for="passwd">비밀번호 : </label></td>
						<td class="td_right"><input type="password" name="user_passwd"
							id="passwd" /></td>
					</tr>
				</table>

				<input type="submit" value="로그인" id="selectButton"
					onclick="href='my_page.jsp'" />
			</fieldset>
		</form>
	</section>
</body>
</html>
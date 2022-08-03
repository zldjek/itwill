<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myInfoUpdate.jsp</title>
</head>
<body>
	<h2>내정보 수정</h2>
		<form action="myInfoUpdate.bo" method="post">
 			<table>
   				<tr>
     				<td><p>아이디</p></td>
     				<td><input type="text" name="member_id" value="" disabled="disabled" ></td>
   				</tr>
 		
   				<tr>
     				<td><p>이름</p></td>
     				<td><input type="text" name="member_name" value="" disabled="disabled"></td>
   				</tr>
   				
 				<tr>
     				<td><p>비밀번호</p></td>
     				<td><input type="password" name="member_passwd" value="" ></td>
     			</tr>
     			
     			<tr>	
     				<td><p>비밀번호재확인</p></td>
     				<td><input type="password" name="member_passwd" value="" ></td>
   				</tr>
   		
   				<tr>
     				<td><p>전화번호</p></td>
     				<td><input type="text"  name="member_phone" value=""></td>
   				</tr>
   				
   				<tr>
     				<td><p>주소</p></td>
     				<td><input type="text"  name="member_address" value=""></td>
   				</tr>
   				
   				<tr>
     				<td><p>이메일</p></td>
     				<td><input type="text" name="member_email"  value="" ></td>
   				</tr>
   				
   				<tr>
    				<td><input type="submit" value="수정하기" onclick="href='mypageUpdate.bo'">
      				 <input type="reset" value="다시입력" ></td>
   				</tr>
 			</table>
		</form>
</body>
</html>
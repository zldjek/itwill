<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>mypage.jsp</title>

</head>
<body>
	<h1>마이페이지</h1>
	<table border="1">
		<tr><td>회원정보확인</td></tr>
		<tr><td><a href="member_update.jsp">회원정보 수정</a></td></tr>
		<tr><td><a href="member_info.jsp">회원정보 조회</a></td></tr>
		<tr><td><a href="member_delete">회원 탈퇴</a></td></tr>
		
		<tr><td>주문내역확인</td></tr>
		<tr><td><a href="order_lookup.jsp">배송 조회</a></td></tr>
		<tr><td><a href="order_cancel.jsp">배송 취소</a></td></tr>
		<tr><td><a href="order_inquiry.jsp">배송 문의</a></td></tr>
	</table>
</body>
</html>
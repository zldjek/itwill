<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>oderLookup</title>
</head>
<body>
	<h1>주문배송조회</h1>

	<section>
		
			<img src="#"/>
			<b>상품번호 : ${order.order_id }</b> <br>
			<b>상품명   : ${order.order_name }</b> <br>
			<b>상품가격 : ${order.order_price }</b> <br>
			<b>상품내용 : ${order.oder_content }</b> <br>
		</section>
		<div>
			<a href="#">쇼핑계속하기</a>
			<a href="#">장바구니에담기</a>
		</div>
	<input type="button" value="이전페이지로이동" onclick="history.back()">
	</section>
</body>
</html>
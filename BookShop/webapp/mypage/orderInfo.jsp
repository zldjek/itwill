<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orderInfo.jsp</title>
</head>
<body>
	<h1>주문내역 확인</h1>
	<div align="center">
	<form action="">
		<table border="1">
			<tr>주문상품정보</tr>
				<tr>
					<td>상품번호</td><td></td>
					<td>상품이미지</td>
					<td>상품내용</td>
				</tr>
				<tr><td>상품명</td><td></td>
				<td rowspan="4"></td>
				<td rowspan="4"></td>
				</tr>
				<tr><td>상품가격</td><td></td></tr>
				<tr><td>상품수량</td><td></td></tr>
				<tr><td>상품날짜</td><td></td></tr>
				
				
				<tr><td></td>
				<td><a href="orderLookup.jsp">주문배송조회</a></td>
				<td><a href="orderInquiry.jsp">배송상품문의</a></td>
				<td><a href="orderCancel.jsp">상품주문취소</a></td>
				</tr>
		</table>
	</form>
	</div>
</body>
</html>
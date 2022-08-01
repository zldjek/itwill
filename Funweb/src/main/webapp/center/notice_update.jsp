<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 글번호, 페이지번호 가져오기
int idx = Integer.parseInt(request.getParameter("idx"));
String pageNum = request.getParameter("pageNum");

// 번호를 사용하여 게시물 정보 조회 => BoardDAO 객체의 selectBoard() 메서드 재사용
// => 파라미터 : 글번호(idx), 리턴타입 : BoardDTO
BoardDAO dao = new BoardDAO();
BoardDTO board = dao.selectBoard(idx);
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>center/notice_update.jsp</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrap">
		<!-- 헤더 들어가는곳 -->
		<jsp:include page="../inc/top.jsp" />
		<!-- 헤더 들어가는곳 -->

		<!-- 본문들어가는 곳 -->
		<!-- 본문 메인 이미지 -->
		<div id="sub_img_center"></div>
		<!-- 왼쪽 메뉴 -->
		<nav id="sub_menu">
			<ul>
				<li><a href="#">Notice</a></li>
				<li><a href="#">Public News</a></li>
				<li><a href="#">Driver Download</a></li>
				<li><a href="#">Service Policy</a></li>
			</ul>
		</nav>
		<!-- 본문 내용 -->
		<article>
			<h1>Notice Update</h1>
			<form action="notice_updatePro.jsp" method="post"> <!-- updateBoard() -->
				<%-- 게시물을 지정하기 위해 게시물 번호(idx)를 함께 전달(페이지 번호도 포함) --%>
				<input type="hidden" name="idx" value="<%=idx %>">
				<input type="hidden" name="pageNum" value="<%=pageNum %>">
				<table id="notice">
					<tr>
						<td>글쓴이</td>
						<td><input type="text" name="name" required="required" value="<%=board.getName()%>"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pass" required="required"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="subject" required="required" value="<%=board.getSubject()%>"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea rows="10" cols="20" name="content" required="required"><%=board.getContent() %></textarea></td>
					</tr>
				</table>

				<div id="table_search">
					<input type="submit" value="글수정" class="btn">
				</div>
			</form>
			<div class="clear"></div>
		</article>


		<div class="clear"></div>
		<!-- 푸터 들어가는곳 -->
		<jsp:include page="../inc/bottom.jsp" />
		<!-- 푸터 들어가는곳 -->
	</div>
</body>
</html>



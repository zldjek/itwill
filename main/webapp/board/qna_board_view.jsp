<%@page import="vo.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
	#articleForm {
		width: 500px;
		height: 550px;
		border: 1px solid red;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		border: 1px solid black;
		border-collapse: collapse; 
	 	width: 500px;
	}
	
	th {
		text-align: center;
	}
	
	td {
		width: 150px;
		text-align: center;
	}
	
	#basicInfoArea {
		height: 70px;
		text-align: center;
	}
	
	#articleContentArea {
		background: orange;
		margin-top: 20px;
		height: 350px;
		text-align: center;
		overflow: auto;
		white-space: pre-line;
	}
	
	#commandList {
		margin: auto;
		width: 500px;
		text-align: center;
	}
</style>
</head>
<body>
	<!-- 게시판 상세내용 보기 -->
	<section id="articleForm">
		<h2>글 상세내용 보기</h2>
		<section id="basicInfoArea">
			<table border="1">
			<tr><th width="70">제 목</th><td colspan="3" >${board.board_subject }</td></tr>
			<tr>
				<th width="70">작성자</th><td>${board.board_name }</td>
				<th width="70">작성일</th><td>${board.board_date }</td>
			</tr>
			<tr>
				<th width="70">첨부파일</th>
				<td>
					<!-- 
					파일명은 원본 파일명을 표시하고, 다운로드 파일 대상은 실제 업로드 파일명,
					실제 다운로드 되는 파일명은 원본 파일명으로 변경하여 다운로드
					-->
					<a href="upload/${board.board_real_file }" download="${board.board_file }">
						${board.board_file }
					</a>
				</td>
				<th width="70">조회수</th>
				<td>${board.board_readcount }</td>
			</tr>
			</table>
		</section>
		<section id="articleContentArea">
			${board.board_content }
		</section>
	</section>
	<section id="commandList">
		<input type="button" value="답변" onclick="location.href='BoardReplyForm.bo?board_num=${board.board_num}&pageNum=${param.pageNum}'">
		<input type="button" value="수정" onclick="location.href='BoardModifyForm.bo?board_num=${board.board_num}&pageNum=${param.pageNum}'">
		<input type="button" value="삭제" onclick="location.href='BoardDeleteForm.bo?board_num=${board.board_num}&pageNum=${param.pageNum}'">
		<input type="button" value="목록" onclick="location.href='BoardList.bo?pageNum=${param.pageNum}'">
	</section>
</body>
</html>

















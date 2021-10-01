<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>My Homepage</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
</head>
<body>
	<table border="1" width="640">
		<tr>
			<td colspan="6"><h3>게시판</h3></td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>작성일</th>
			<th>&nbsp;</th>
		</tr>
		<tr>
			<td>3</td>
			<td><a href="">세 번째 글입니다.</a></td>
			<td>남승균</td>
			<td>3</td>
			<td>2015-10-11 12:04:20</td>
			<td><a href="">삭제</a></td>
		</tr>
		<tr>
			<td>2</td>
			<td><a href="">두 번째 글입니다.</a></td>
			<td>남승균</td>
			<td>3</td>
			<td>2015-10-02 12:04:12</td>
			<td><a href="" class="del">삭제</a></td>
		</tr>
		<tr>
			<td>1</td>
			<td><a href="">첫 번째 글입니다.</a></td>
			<td>남승균</td>
			<td>3</td>
			<td>2015-09-25 07:24:32</td>
			<td><a href="">삭제</a></td>
		</tr>
		<tr>
			<td colspan="6"><a href="<c:url value="/board/write"/>">글쓰기</a></td>
		</tr>
	</table>
</body>
</html>

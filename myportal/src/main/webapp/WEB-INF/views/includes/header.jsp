<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div id="header">
			<h1><a href="#">My Portal</a></h1>
			<ul>
				<c:choose>
				<c:when test="${empty authUser }">
				<!-- 로그인 안했을 때 -->
				<li><a href="<c:url value="/users/login" />">로그인</a></li>
				<li><a href="<c:url value="/users/join" />">회원가입</a></li>
				</c:when>
				<c:otherwise>
				<!-- 로그인 했을 때 -->
				<li><a href="#">회원정보수정</a></li>
				<li><a href="<c:url value="/users/logout" />">로그아웃</a></li>
				<li>${authUser.name }님 안녕하세요 ^^;</li>
				</c:otherwise>
				</c:choose>
			</ul>
		</div>
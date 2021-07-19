<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
</head>
<body>
<a href="/"><img src="/img/logo.png"></a>
<h3>main page</h3>
<c:choose>
	<c:when test="${empty memberId || empty dto}">
		<a href="joinForm">회원가입</a>
		<a href="loginForm">로그인</a>
	</c:when>
	<c:otherwise>
		<div>로그정보 : ${memberId}[${dto.grade}]</div>
		<a href="logout">로그아웃</a>
		<a href="myInfo">마이페이지</a>
		
		<!-- 관리자 권한 전체회원조회 메뉴 -->
		<c:if test="${grade == 'A'}">
			[관리자] <a href="memberList">전체회원조회</a>
		</c:if>
	</c:otherwise>
</c:choose>

<h3>main 페이지</h3>
<c:if test="${not empty message}">
	result 메시지 :: ${message}
</c:if>
</body>
</html>
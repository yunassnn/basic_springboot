<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!-- joinForm.jsp -->
<a href="joinForm">회원가입</a>
<!-- loginForm.jsp -->
<a href="loginForm">로그인</a>

<h3>회원가입페이지</h3>
<form action="join" method="post">
	<input type="text" name="memberId" autofocus="autofocus" required="required"/>
	<input type="password" name="memberPw" required="required" />
	<input type="text" name="name" required="required"/>
	<input type="text" name="mobile" required="required" />
	<input type="text" name="email" required="required"/>
	<input type="submit" value="가입" />
	<input type="reset" value="취소" />
</form>

</body>
</html>
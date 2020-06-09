<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#joinFormArea{
		width: 400px;
		margin: auto;
		border: 1px solid gray;
	}
	table{
		width: 380px;
		margin: auto;
		text-align: center;
	}
</style>
</head>
<body>
<section id="joinFormArea">
	<form name="joinform" action="memberJoinAction.do" method="post">
	<table>
		<tr>
			<td colspan="2"><h1>회원 가입 페이지</h1></td>
		</tr>
		<tr>
			<td><label for="member_id">아이디 : </label></td>
			<td><input type="text" name="member_id" id="member_id"/></td>
		</tr>
		<tr>
			<td><label for="member_pw">비밀번호 : </label></td>
			<td><input type="password" name="member_pw" id="member_pw"/></td>
		</tr>
		<tr>
			<td><label for="member_name">이름 : </label></td>
			<td><input type="text" name="member_name" id="member_name"/></td>
		</tr>
		<tr>
			<td><label for="member_age">나이 : </label></td>
			<td><input type="text" name="member_age" id="member_age"/></td>
		</tr>
		<tr>
			<td><label for="member_gender">성별 : </label></td>
			<td>
				<input type="radio" name="member_gender" value="남" checked="checked" id="member_gender"/>남자
				<input type="radio" name="member_gender" value="여" id="member_gender"/>여자
			</td>
		</tr>
		<tr>
			<td><label for="member_email">이메일 주소 : </label></td>
			<td><input type="text" name="member_email" id="member_email"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="javascript:joinform.submit()">회원가입</a>&nbsp;&nbsp;
				<a href="javascript:joinform.reset()">다시작성</a>
			</td>
		</tr>
	</table>
	</form>
</section>
</body>
</html>
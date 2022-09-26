<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center"><b>기본 에러 화면입니다.</b></td>
		</tr>
	</table>
	<br />
	<table width="100%" border="1" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td align="center">
				<br />
				MESSAGE : ${exception.message }
				<br /><br /><br /><br />
			</td>
		</tr>
	</table>
</body>
</html>
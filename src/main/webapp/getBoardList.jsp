<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
	<title><spring:message code="message.board.list.mainTitle" /></title>
</head>
<body>
<div align="center">
	<h1><spring:message code="message.board.list.mainTitle" /></h1>
	<h3>
		${userName}<spring:message code="message.board.list.welcomeMsg" />
		<a href="logout.do">Log-Out</a>
	</h3>
	<form action="getBoardList.do" method="post">
		<table border="1" cellpadding="0" cellpadding="0" width="700">
			<tr>
				<td align="right">
					<select name="searchCondition">
					<c:forEach var="option" items="${conditionMap}">
						<option value="${option.value}">${option.key}</option>
					</c:forEach>
						<!-- <option value="TITLE">????</option>
						<option value="CONTENT">????</option> -->
					</select>
					<input name="searchKeyword" type="text" />
					<input type="submit" value="<spring:message code="message.board.list.search.condition.btn" />" />
				</td>
			</tr>
		</table>
	</form>
	
	<table border="1" cellpadding="0" cellpadding="0" width="700">
		<tr>
			<th bgcolor="yellow" width="100">
				<spring:message code="message.board.list.table.head.seq" />
			</th>
			<th bgcolor="yellow" width="200">
				<spring:message code="message.board.list.table.head.title" /></th>
			<th bgcolor="yellow" width="150"><spring:message code="message.board.list.table.head.writer" />
			</th>
			<th bgcolor="yellow" width="150">
				<spring:message code="message.board.list.table.head.regDate" />
			</th>
			<th bgcolor="yellow" width="100">
				<spring:message code="message.board.list.table.head.cnt" />
			</th>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.seq}</td>
				<td align="left">
					<a href="getBoard.do?seq=${board.seq}">${board.title}</a>
				</td>
				<td>${board.writer}</td>
				<td>${board.regDate}</td>
				<td>${board.cnt}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="insertBoard.jsp">
		<spring:message code="message.board.list.link.insertBoard" />
	</a>
	
</div>
</body>
</html>
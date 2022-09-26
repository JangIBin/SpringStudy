<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.global.biz.board.impl.BoardDAO" %>
<%@ page import="com.global.biz.board.BoardVO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 등록</title>
</head>
<body>
   <div align="center">
      <h1>글 등록</h1>
      <a href="logout.do">Log-out</a>
      <hr>
      <form action="insertBoard.do" method="post" enctype="multipart/form-data">
         <table border="1" cellpadding="0" cellspacing="0">
            <tr>
               <td bgcolor="yellow" width="70">제목</td>
               <td align="left" bgcolor="yellow" width="70">
                  <input type="text" name="title">
               </td>
            </tr>
            <tr>
               <td bgcolor="yellow">작성자</td>
               <td align="left" bgcolor="yellow" width="70">
                  <input type="text" name="writer" size="10">
               </td>
            </tr>
            <tr>
               <td bgcolor="yellow">내용</td>
               <td align="left">
                  <textarea name="content" rows="10" cols="40"></textarea>
               </td>
            </tr>
            
            <tr>
               <td bgcolor="yellow" width="70">파일 업로드</td>
               <td align="left">
                  <input type="file" name="uploadFile">
               </td>
            </tr>
            
            <tr>
               <td colspan="2" align="center">
                  <input type="submit" value="글 등록">
               </td>
            </tr>
         </table>
      </form>
      <hr>
      <a href="getBoardList.do">글 목록</a>
   </div>
</body>
</html>
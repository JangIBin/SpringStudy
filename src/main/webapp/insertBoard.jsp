<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.global.biz.board.impl.BoardDAO" %>
<%@ page import="com.global.biz.board.BoardVO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ���</title>
</head>
<body>
   <div align="center">
      <h1>�� ���</h1>
      <a href="logout.do">Log-out</a>
      <hr>
      <form action="insertBoard.do" method="post" enctype="multipart/form-data">
         <table border="1" cellpadding="0" cellspacing="0">
            <tr>
               <td bgcolor="yellow" width="70">����</td>
               <td align="left" bgcolor="yellow" width="70">
                  <input type="text" name="title">
               </td>
            </tr>
            <tr>
               <td bgcolor="yellow">�ۼ���</td>
               <td align="left" bgcolor="yellow" width="70">
                  <input type="text" name="writer" size="10">
               </td>
            </tr>
            <tr>
               <td bgcolor="yellow">����</td>
               <td align="left">
                  <textarea name="content" rows="10" cols="40"></textarea>
               </td>
            </tr>
            
            <tr>
               <td bgcolor="yellow" width="70">���� ���ε�</td>
               <td align="left">
                  <input type="file" name="uploadFile">
               </td>
            </tr>
            
            <tr>
               <td colspan="2" align="center">
                  <input type="submit" value="�� ���">
               </td>
            </tr>
         </table>
      </form>
      <hr>
      <a href="getBoardList.do">�� ���</a>
   </div>
</body>
</html>
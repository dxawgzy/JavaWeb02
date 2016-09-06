<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<br/><br/><br/>
<center>
     <form name="loginForm" method="post" action="LoginServlet">
    <table>
    
     <tr> 
        <td colspan="2" align="center"><b><font color="#0000FF">用户登录</font></b></td>
      </tr>
      
      <tr>
        <td><div align="right">用户名:</div></td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td><div align="right">密&nbsp;&nbsp;&nbsp;码:</div></td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
         <td>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="submit" name="submit1" value="登录">
         </td>
         <td>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="submit" name="submit2" value="注册">
         </td>
      </tr>
    </table>
  </form>
  </center>
</body>
</html>



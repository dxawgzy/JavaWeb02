<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
<br/><br/><br/>
<center>
     <form name="registerForm" method="post" action="RegisterServlet">
    <table>
    
      <tr> 
        <td colspan="2" align="center"><b><font color="#0000FF">用户注册</font></b></td>
      </tr>
     
      <tr>
        <td><div align="right">用&nbsp;户&nbsp;名:</div></td>
        <td><input type="text" name="username"></td>
      </tr>
      
      <tr>
        <td><div align="right">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</div></td>
        <td><input type="password" name="password"></td>
      </tr>
<!--      
      <tr>
        <td><div align="right">确认密码:</div></td>
        <td><input type="password" name="password"></td>
      </tr>
 -->     
      <tr>
        <td><div align="right">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</div></td>
        <td><input type="text" name="name"></td>
      </tr>
      
      <tr>
        <td><div align="right">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</div></td>
        <td><input type="text" name="telephone" onkeyup="this.value=this.value.replace(/\D/g, '')"></td>
      </tr>
      
      <tr>
        <td><div align="right">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</div></td>
        <td><input type="text" name="email"></td>
      </tr>
      
      <tr>
        <td><div align="right">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:</div></td>
        <td><input type="text" name="address"></td>
      </tr>
      
      <tr>
         <td>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="submit" name="register" value="注册">
         </td>
         <td>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="reset" name="cancel" value="取消">
         </td>
      </tr>
    </table>
  </form>
  </center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body>
<br/><br/><br/>
<center>
     <form name="RentForm" method="GET" action="orderlist.jsp">
    
      <tr> 
        <td colspan="2" align="center"><b><font color="#0000FF">购物车</font></b></td>
      </tr>
     
     <table border="1" align="center" width="500px" cellspacing=0 cellpadding=0>
     
     <tr> 
        <td>书号</td>
        <td>书名</td>
        <td>作者</td>
        <td>出版社</td>
        <td>价格</td>
        <td>数量</td>
        <td>取消</td>
      </tr>
      
       <tr> 
        <td>0</td>
        <td>0</td>
        <td>0</td>
        <td>0</td>
        <td>0</td>
        <td>0</td>
        <td><input type="button" name="cancel" value="取消"></td>
      </tr>
      
      <tr>
        <td>总金额</td>
      </tr>
 
    </table>
  </form>
  </center>
</body>
</html>


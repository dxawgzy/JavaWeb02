<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="book.Bean.Book"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍列表</title>
</head>
<body>

<h2>欢迎您！</h2>

<%
List<Book> all = Book.showBook();
Iterator<Book> iter = all.iterator();
%>
<br/><br/><br/>
<center>
     <form name="BookForm" method="POST" action="bookdetail.jsp">
    
      <tr> 
        <td colspan="2" align="center"><b><font color="#0000FF">书籍列表</font></b></td>
      </tr>
     
    <table border="1" align="center" width="500px" cellspacing=0 cellpadding=0>
     
      <tr> 
        <td>编号</td>
        <td>书名</td>
        <td>作者</td>
        <td>出版社</td>
        <td>租金</td>
        <td>剩余数量</td>
        <td>购买</td>
      </tr>
      
<%
    while(iter.hasNext()) {
    	Book bk = iter.next();
%>
      
      <tr>
        <td><%=bk.getBook_id()%></td>
        <td><%=bk.getBookname()%></td>
        <td><%=bk.getAuthor()%></td>
        <td><%=bk.getPress()%></td>
        <td><%=bk.getPrice()%></td>
        <td><%=bk.getQuantity()%></td>
        <td><input type="button" name="choose_"+bk.getBook_id() value="购买"></td>
      </tr>
<%
    }
%> 
       
    </table>
  </form>
  </center>
</body>
</html>



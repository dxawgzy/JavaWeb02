package book.Servlet;   //用于变成过程中的测试 试验

import book.Bean.Book;
import book.Bean.Customer;
import book.common.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Test1 {
	
	public static List<Book> showBook() throws Exception {
		List<Book> all = new ArrayList<Book>();
		Database db = new Database();
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select * from book";
		//通过statement object 执行SQL语句
		//executeQuery()运行给定的SQL语句，返回一个查询结果集
		ResultSet rs = stmt.executeQuery(sql);
		Book bk = null;
		while(rs.next()){    //.next()用来遍历ResultSet这个结果集				
			//int id = rs.getInt(1);
			//String bookname = rs.getString(2);
			String author = rs.getString(3);
			String press = rs.getString(4);
			Float price = rs.getFloat(5);
			int quantity = rs.getInt(6);
			System.out.print("编号：" + rs.getInt(1) + "；");
			System.out.print("书名：" + rs.getString(2) + "；");
			System.out.print("作者：" + author + "；");
			System.out.print("出版社：" + press + "；");
			System.out.print("价格：" + price + "；");
			System.out.println("剩余数量：" + quantity);
			System.out.println("--------------------------------");		
			
			bk = new Book();
			bk.setBook_id(rs.getInt(1));
			bk.setBookname(rs.getString(2));
			bk.setAuthor(rs.getString(3));
			bk.setPress(rs.getString(4));
			bk.setPrice(rs.getFloat(5));
			bk.setQuantity(rs.getInt(6));
			all.add(bk);	
		}
			//关闭数据库连接，调用close()方法
	        rs.close();
	        stmt.close();
	        conn.close();
	        //System.out.println(all);
	        return all;
	}
	
	
    //注册时先判断该用户名是否存在
	public static boolean select() throws Exception {
		boolean flag = false;
		Customer cust = new Customer();
		Database db = new Database();
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select * from user where username="+cust.getUsername();
		ResultSet rs = stmt.executeQuery(sql);
		while(!rs.next()){    //.next()用来遍历ResultSet这个结果集
			flag = true;	
		}
        rs.close();
        stmt.close();
        conn.close();
        return flag;
	}
	
	
    //注册
	public static void saveInfo() throws Exception {
		boolean flag = false;
		//flag = select();
		Database db = new Database();
		Customer cust = new Customer();
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		String sql_select = "select * from user where username="+cust.getUsername();
		String sql_insert = "insert into user (username,password,name,telephone,email,address) values( " 
						+ "'"+cust.getUsername() + "',"
						+ "'"+cust.getPassword() + "'," 
						+ "'"+cust.getName() + "'," 
						+ "'"+cust.getTelephone() + "'," 
						+ "'"+cust.getEmail() + "'," 
						+ "'"+cust.getAddress() + "'"
						+ ")";
		
		ResultSet rs = stmt.executeQuery(sql_select);
		while(!rs.next()){    //.next()用来遍历ResultSet这个结果集
			flag = true;	
		}
		while(flag){
			stmt.executeUpdate(sql_insert);  //executeUpdate()执行insert，update，add语句
		}
		stmt.close();  
		conn.close();
	}
	
	
	public static void main(String[] args) throws Exception {
		//List<Book> all = showBook();
		//Iterator<Book> iter = all.iterator();
	    /*
		while(iter.hasNext()) {
	    	Book bk = iter.next();
	    	System.out.print("编号：" + bk.getId() + "；");
			System.out.print("书名：" + bk.getBookname() + "；");
			System.out.print("作者：" + bk.getAuthor() + "；");
			System.out.print("出版社：" + bk.getPress() + "；");
			System.out.print("价格：" + bk.getPrice() + "；");
			System.out.println("剩余数量：" + bk.getQuantity());
			System.out.println("--------------------------------");		
	    }
	    */
		
		saveInfo();
	    
	}
	    

}





package book.Bean;  //书籍信息公共类

import java.sql.*;
import java.util.*;

import book.common.Database;

public class Book{
	private Integer book_id;
	private String bookname;
	private String author;
	private String press;
	private Float price;
	private Integer quantity;
    
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public static List<Book> showBook() throws Exception {
	//public List<Book> showBook() throws Exception {
		List<Book> all = new ArrayList<Book>();
		Database db = new Database();
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select * from book";
		//通过statement object 执行SQL语句
		ResultSet rs = stmt.executeQuery(sql);  //executeQuery()运行给定的SQL语句，返回一个查询结果集
		Book bk = null;
		while(rs.next()){    //.next()用来遍历ResultSet这个结果集
			bk = new Book();
			bk.setBook_id(rs.getInt(1));
			bk.setBookname(rs.getString(2));
			bk.setAuthor(rs.getString(3));
			bk.setPress(rs.getString(4));
			bk.setPrice(rs.getFloat(5));
			bk.setQuantity(rs.getInt(6));
			all.add(bk);
		}
            rs.close();   //关闭数据库连接，调用close()方法
            stmt.close();
            conn.close();
            return all;
	}

	
//	//每个用户点击购买第一本书籍时，需为其创建一个数据表，不同用户数据表命名要不同
//	//先要判断某个用户的对应的数据表是否存在
//	//用户注册时判断用户名是否存在，注册成功后即创建该表
//	
//	//使用外键，订单只需一张表，不需为每个用户分别建立一张表
//	public void createOrderTable(String username) throws Exception {
//		Database db = new Database();
//		Connection conn = db.getConnection();
//		//Statement stmt = conn.createStatement();
//		PreparedStatement pstmt = null;
//		String sql = "create table order_"+ username +" (" +
//				"id  int(11)  auto_increment  primary key," +
//				"bookname  varchar(80)  not null," +
//				"author  varchar(40)  not null," +
//				"press   varchar(60)  not null," +
//				"price  float(8,2)  not null," +
//				"quantity  int(4)  not null)";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.executeUpdate();
//		pstmt.close();
//        conn.close(); 
//	}
	
	
	public void orderBook(Integer user_id) throws Exception {
		Database db = new Database();
		Connection conn = db.getConnection();
		//Statement stmt = conn.createStatement();
		PreparedStatement pstmt = null;
		//String sql = "insert into order (user_id,book_id,bookname,author,press,price,quantity) values(?,?,?,?,?,?,?)";  
		String sql = "insert into order (user_id,book_id,bookname,author,press,price) values(?,?,?,?,?,?)"; 
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,user_id);
		pstmt.setInt(2,this.getBook_id());
		pstmt.setString(3,this.getBookname());
		pstmt.setString(4,this.getAuthor());
		pstmt.setString(5,getPress());
		pstmt.setFloat(6,this.getPrice());
		//pstmt.setInt(7,this.getQuantity());
		pstmt.executeUpdate();
		pstmt.close();
        conn.close(); 
	}
	
	//在 order_copy1 中只保存 user_id 和 book_id, Quantity 默认为 1 
	public void orderBook1(Integer user_id) throws Exception {
		Database db = new Database();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into order_copy1 (user_id,book_id) values(?,?)"; 
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,user_id);
		pstmt.setInt(2,this.getBook_id());
		pstmt.executeUpdate();
		pstmt.close();
        conn.close(); 
	}


}





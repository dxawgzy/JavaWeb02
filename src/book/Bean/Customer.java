package book.Bean;  //登录注册公共类

import java.sql.*;
import java.util.*;

import book.common.Database;

public class Customer{
	private Integer user_id;
	private String username;
	private String password;
	private String name;
	private String telephone;  //telephone使用Integer有问题
	private String email;
	private String address;
    
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTelephone() {
		//String tele = String.valueOf(telephone);
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//登陆验证的方法
	public boolean login(String username,String password) throws Exception {
		boolean succ =false;
		Database db = new Database();
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select * from user where username='"+username+"' and password='"+password+"'";
		//通过statement object 执行SQL语句
		ResultSet rs = stmt.executeQuery(sql);  //executeQuery()运行给定的SQL语句，返回一个查询结果集
		while(rs.next()){    //.next()用来遍历ResultSet这个结果集
			succ = true;	
		}
        rs.close();   //关闭数据库连接，调用close()方法
        stmt.close();
        conn.close();
        return succ;
	}
	
	
    //注册时先判断该用户名是否存在
	public boolean select() throws Exception {
		boolean flag = false;
		Database db = new Database();
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select * from user where username='"+this.getUsername()+"'";
		ResultSet rs = stmt.executeQuery(sql);
		if(!rs.next()){    //.next()用来遍历ResultSet这个结果集
			flag = true;
		}else {
			flag = false;
		}
        rs.close();
        stmt.close();
        conn.close();
        return flag;
	}
	
	
    //注册
	public boolean saveInfo() throws Exception {
		boolean succ = false;
		Database db = new Database();
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		//PreparedStatement pstmt = null;
		String sql = "insert into user (username,password,name,telephone,email,address) values( " 
						+ "'"+this.getUsername() + "',"
						+ "'"+this.getPassword() + "'," 
						+ "'"+this.getName() + "'," 
						+ "'"+this.getTelephone() + "'," 
						+ "'"+this.getEmail() + "'," 
						+ "'"+this.getAddress() + "'"
						+ ")";
		/*
		String sql = "insert into user (username,password,name,telephone,email,address) values(?,?,?,?,?,?)";  
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,this.getUsername());
		pstmt.setString(2,this.getPassword());
		pstmt.setString(3,this.getName());
		pstmt.setString(4,this.getTelephone());
		pstmt.setString(5,this.getEmail());
		pstmt.setString(6,this.getAddress());
		pstmt.executeUpdate();
		pstmt.close();
		*/
		/*
		 * 注册时判断所有栏目是否都不为空
		if((this.getUsername()!=null)&&(this.getPassword()!=null)){
			stmt.executeUpdate(sql);  //executeUpdate()执行insert，update，add语句
			succ = true;
		}else{
			succ = false;
		}
		*/
		stmt.executeUpdate(sql);  //executeUpdate()执行insert，update，add语句
		succ = true;
        stmt.close();  
        conn.close();
        return succ;
	}
	
	
	
    //使用Ajax注册时先判断该用户名是否存在
	public boolean count() throws Exception {
		boolean flag = false;
		Database db = new Database();
		Connection conn = db.getConnection();
		//Statement stmt = conn.createStatement();
		PreparedStatement pstmt = null;
		//String sql = "select count(username) from user where username='"+this.getUsername()+"'";
		String sql = "select count(username) from user where username=?";		
		//ResultSet rs = stmt.executeQuery(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,this.getUsername());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){    //.next()用来遍历ResultSet这个结果集
			if(rs.getInt(1)>0){
			//if(rs.getInt("username")>0){
				return true;
			}else {
				return false;
			}
		}
        rs.close();
        pstmt.close();
        conn.close();
        return flag;

	}
	
	
	
}




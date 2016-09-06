package book.common;   /*数据库连接 */
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/bookshop?useSSL=false";
	public static final String DBUSER = "root";
	public static final String DBPASS = "123456";
	public Connection conn = null;
	
	public Database() throws Exception {

	}
	
	public Connection getConnection(){
        try{
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
	}
/*	
	public void close() throws Exception{
		if(this.conn!=null){
			try{
				this.conn.close();
			}catch (Exception e){
				throw e;
			}
		}
	}
*/	
	
}



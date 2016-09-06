package book.Servlet;  //此程序目前尚未作用

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Bean.Book;

public class BookServlet extends HttpServlet {
	
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private ServletContext sc = null;
	  
	//Initialize 
	public void init() throws ServletException {
	    super.init();
	    sc = this.getServletContext();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	               throws ServletException, IOException {
		//Book bk = new Book();
	    try {
	        //bk.showBook();
	    	Book.showBook();
	    }catch (Exception e) {
	    	e.printStackTrace();
	    }
	}	

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	              throws ServletException, IOException {
		doGet(request, response);
	}
	
    //Clean up resources
    public void destroy() {
    	
    }
    

}



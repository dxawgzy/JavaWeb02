package book.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Bean.Book;
import book.Bean.Customer;

public class RegisterServlet extends HttpServlet {
	
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private ServletContext sc = null;
	
	//Initialize 
	public void init() throws ServletException {
	    super.init();
	    sc = this.getServletContext();
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	             throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	             throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		Customer cust = new Customer();
	    cust.setUsername(request.getParameter("username"));
	    cust.setPassword(request.getParameter("password"));
	    cust.setName(request.getParameter("name"));
	    cust.setTelephone(request.getParameter("telephone"));
	    cust.setEmail(request.getParameter("email"));
	    cust.setAddress(request.getParameter("address"));
	    boolean flag = false;	    
	    try {
	    	flag = cust.select();
	    }catch (Exception ex) {
		    ex.printStackTrace();
	    }
		if (flag){
			try {
				cust.saveInfo();
			    //response.setContentType("text/html;charset=UTF-8");
			    //PrintWriter out=response.getWriter();
			    //out.println("<h3>注册成功！</h3>");
		    	response.sendRedirect("register_success.jsp");
		    }catch (Exception ex) {
			    ex.printStackTrace();
		    }
		}else{
			response.sendRedirect("register_fail.jsp");
		}
	    return;
	}
	
    //Clean up resources
    public void destroy() {
    	
    }
	
}




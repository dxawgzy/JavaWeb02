package book.Servlet;

import book.Bean.Book;
import book.Bean.Customer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private ServletContext sc = null;
	  
	//Initialize 
	public void init() throws ServletException {
	    super.init();
	    sc = this.getServletContext();
    }

    //Process the HTTP Get request
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException{
    	String varname = request.getParameter("username");
        String varpassword = request.getParameter("password");
        String reg = request.getParameter("submit2");
	    if(reg != null){
	    	response.sendRedirect("register.jsp");
	        return;
	    }
	    /*String register = request.getParameter("register");
	    if(register != null){
	        doRegister(request, response);
	        return;
	    }
	    */

	    boolean succ = false;
	    Customer cu = new Customer();
	    try {
	        succ = cu.login(varname,varpassword);
	    }catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	
	    if(succ){
		    //response.setContentType("text/html;charset=UTF-8");
		    //PrintWriter out=response.getWriter();
		    //out.println("<h3>登录成功！</h3>");
	    	response.sendRedirect("bookdetails.jsp");
	        /*
	        this.doBrowse(request, response);
	        HttpSession mysession = request.getSession(false);
	        RentList mylist = new RentList();
	        mysession.setAttribute(username,mylist);
	        mysession.setAttribute("username",username);
	        */
	    }else{
		    //response.setContentType("text/html;charset=UTF-8");
		    //PrintWriter out=response.getWriter();
	    	//out.println("<h3>用户名或密码错误！</h3>");
	    	response.sendRedirect("login_failure.jsp");
	    	//this.doError(request, response);
		}
	    return;
	 
    }

    //Process the HTTP Post request
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException{
        doGet(request, response);
    }
  
    private void doBrowse(HttpServletRequest request, HttpServletResponse response) 
                 throws ServletException, IOException{
    	RequestDispatcher rd = sc.getRequestDispatcher("/bookdetails.jsp");
    	rd.forward(request,response);
    }

    private void doRegister(HttpServletRequest request, HttpServletResponse response) 
                 throws ServletException, IOException{
    	Customer cust = new Customer();
        cust.setUsername(request.getParameter("username"));
        cust.setPassword(request.getParameter("password"));
        cust.setName(request.getParameter("name"));
        cust.setTelephone(request.getParameter("telephone"));
        cust.setEmail(request.getParameter("email"));
        cust.setAddress(request.getParameter("address"));
       try {
    	   cust.saveInfo();
       }catch (Exception ex) {
    	   ex.printStackTrace();
       }
       RequestDispatcher rd = sc.getRequestDispatcher("/login.jsp");
       rd.forward(request,response);
    }

    private void doBrowseErr(HttpServletRequest request, HttpServletResponse response) 
                 throws ServletException, IOException{
    	RequestDispatcher rd=sc.getRequestDispatcher("/login.jsp");
        rd.forward(request,response);
    }
 
    private void doError(HttpServletRequest request, HttpServletResponse response) 
                 throws ServletException, IOException{
    	request.setAttribute("error","username or password error!");
	    this.doBrowseErr(request, response);
    }
  
    //Clean up resources
    public void destroy() {
    	
    }

}




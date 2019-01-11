package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.UserDaoImp;
import com.dao.UserDao;

import com.utils.Globle;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.jhtml")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nextUrl = "";
		String hostname = request.getSession().getAttribute("username")+"";
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		UserDao dao = new UserDaoImp();
		System.out.println(Globle.getCode()+request.getParameter("code"));
		if(dao.login(name, password) && Globle.getCode().equals(request.getParameter("code"))){
			request.getSession().setAttribute("username", name);
			nextUrl = "welcomes/welcome.jsp";
		}else{
			nextUrl = "index.html";
		}
		
	 
		if (hostname.equals("null")!=true) {
			nextUrl = "welcomes/welcome.jsp";
		}
	 
		if("exit".equals(request.getParameter("choose"))) {
			request.getSession().removeAttribute("username");
			request.getSession().invalidate();
			nextUrl = "index.html";
		}
		request.getRequestDispatcher(nextUrl).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	
	

}

package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImp;
import com.entity.User;

/**
 * Servlet implementation class ListAllUsersServlet
 */
@WebServlet("/ListAllUsersServlet")
public class ListAllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImp();
		//List<User> users = userDao.queryAll();
		System.out.println("dddddddddddddddddddddddddddd");
		
		int totalCount = userDao.countUsers();
		int pageCount = 5;
		int pageTotal = 0;
		if(totalCount % pageCount == 0){
			pageTotal = totalCount / pageCount;
		}else{
			pageTotal = totalCount / pageCount + 1;
		}
		
		
		int pageNow = 0;
		if(request.getParameter("pageNow") == null){
			pageNow = 1;
		}else{
			pageNow = Integer.parseInt(request.getParameter("pageNow"));
			if(pageNow < 1){
				pageNow = 1;
			}
			if(pageNow > pageTotal){
				pageNow = pageTotal;
			}
		}
		
		List<User> users = userDao.queryUserByPage(pageNow);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("users", users);
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

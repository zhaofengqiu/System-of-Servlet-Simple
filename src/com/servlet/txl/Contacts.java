package com.servlet.txl;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ContactDao;
import com.dao.ContactDaoImp;
import com.dao.UserDao;
import com.dao.UserDaoImp;
import com.entity.*;

/**
 * Servlet implementation class ListAllUsersServlet
 */
@WebServlet("/contains.jhtml")
public class Contacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contacts() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hostname = request.getSession().getAttribute("username")+"";
		ContactDao contactDao = new ContactDaoImp();
		if("getcontacts".equals(request.getParameter("choice")) || request.getParameter("choice")==null) {
			//List<User> users = userDao.queryAll();
			int totalCount = contactDao.countUsers();
			int pageCount = 5;
			int pageTotal = 0;
			if(totalCount % pageCount == 0){
				pageTotal = totalCount / pageCount;
			}else{
				pageTotal = totalCount / pageCount + 1;
			}
			int pageNow ;
			if(request.getParameter("pageNow") == null){
				pageNow = 1;
			}else{
				pageNow = Integer.parseInt(request.getParameter("pageNow"));
				if(pageNow < 1){
					pageNow = 1;
				}else if(pageNow > pageTotal){
					pageNow = pageTotal;
				}
			}
			List<Contact> contacts = contactDao.queryUserByPage(pageNow,hostname);
			request.setAttribute("pageNow", pageNow);
			request.setAttribute("contacts", contacts);
		}else if("createnew".equals(request.getParameter("choice"))) {
			request.setAttribute("create","true");
			
		}else if("update".equals(request.getParameter("choice"))) {
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String qq = request.getParameter("qq");
			String workspace = request.getParameter("workspace");
			String address = request.getParameter("address");
			String postcode = request.getParameter("postcode");
			
			Contact contact = new Contact(hostname,name,sex,phone,email,qq,workspace,address,postcode);		
			if(contactDao.save(contact)){
				response.setStatus(200);
			}else {
				response.setStatus(202);
			}
		}else if("delete".equals(request.getParameter("choice"))) {
			String deletestrid = request.getParameter("id");
			Integer deleteid =Integer.parseInt(deletestrid);
			 if(contactDao.delete(deleteid)) {
				 response.setStatus(200);
			 }else {
				 response.setStatus(202);
			 }
		}
		System.out.println("test");
		System.out.println(request.getParameter("choice"));
		System.out.println(request.getParameter("id"));
		request.getRequestDispatcher("welcomes/welcomecontact.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}


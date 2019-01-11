package com.servlet.infor;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
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
 * Servlet implementation class Showmsg
 */
@WebServlet("/informsg.jhtml")
public class Informsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static final String =
  
    public Informsg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hostname = request.getSession().getAttribute("username")+"";
		if("showmsg".equals(request.getParameter("choice")) || request.getParameter("choice")==null) {
			UserDao userdao = new UserDaoImp();
			User user = userdao.queryOne(hostname);
			System.out.println(user.getId());
			request.setAttribute("user", user);
			request.setAttribute("showmsg", "true");
		}else if("xiugai".equals(request.getParameter("choice"))) {
			UserDao userdao = new UserDaoImp();
			User user = userdao.queryOne(hostname);
			request.setAttribute("user", user);
			request.setAttribute("xiugai", "true");
		}else if("changemsg".equals(request.getParameter("choice"))) {
			String userid = request.getParameter("id");
			Integer id = Integer.parseInt(userid);
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String youbian = request.getParameter("postcode");
			User user = new User(id,name, password, phone, email,youbian);
			UserDao userdao = new UserDaoImp();
			
			if(userdao.update(user)){
				response.setStatus(200);
				request.getSession().setAttribute("username", user.getName());
			}else {
				response.setStatus(202);
			}
		}else if("updateimg".equals(request.getParameter("choice"))) {
			
			InputStream is = request.getPart("image").getInputStream();
//			String file_path = dir_path+request.getSession().getAttribute("User")+".jpg";
			String file_path = request.getServletContext().getRealPath("\\images\\"+request.getSession().getAttribute("username")+".jpg");
			System.out.println(file_path);
			File file=new File(file_path);
	        if(!file.exists()) {
	        	file.createNewFile();
	        }
			System.out.println("file_path:"+file_path);
			FileOutputStream fos = new FileOutputStream(file_path);
			int i=0;
			byte[] buf = new byte[1024*1024*1024];
			while((i = is.read(buf))!=-1) {
				fos.write(buf,0,i);
			}
			fos.close();
			is.close();

			
		}
		request.getRequestDispatcher("welcomes/welcomeinfor.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.servlet.txl;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MessagesDao;
import com.dao.MessagesDaoImp;
import com.entity.Message;
/**
 * Servlet implementation class Messages
 */
@WebServlet("/messages.jhtml")
public class Messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Messages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hostname = request.getSession().getAttribute("username")+"";
		// TODO Auto-generated method stub
		if("showmsg".equals(request.getParameter("choice")) || request.getParameter("choice")==null) {
			MessagesDao MessagesDao = new MessagesDaoImp(hostname);
			//List<User> users = MessagesDao.queryAll();
			
			int totalCount = MessagesDao.countMessages();
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
			
			List<Message> messages = MessagesDao.queryMessagesByPage(pageNow);
			request.setAttribute("pageNow", pageNow);
			request.setAttribute("messages", messages);
		}else if("sendmsg".equals(request.getParameter("choice"))) {
			request.setAttribute("sendmsg","true");
			
		}else if("update".equals(request.getParameter("choice"))) {
			String sender =request.getParameter("sender");
			String content = request.getParameter("content");
			String receiver = request.getParameter("reciver");	
			Message messages = new Message(receiver,content,sender,0);
			
			MessagesDao messagesdao = new MessagesDaoImp();
			
			if(messagesdao.save(messages)){
				response.setStatus(200);
			}else {
				response.setStatus(202);
			}
			
		}else if("delete".equals(request.getParameter("choice"))) {
			String msgId=request.getParameter("id");
			Integer msg_id = Integer.parseInt(msgId);
			MessagesDao messagesdao = new MessagesDaoImp();
			
			if(messagesdao.delete(msg_id)){
				response.setStatus(200);
			}else {
				response.setStatus(202);
			}
		}else if("isread".equals(request.getParameter("choice"))) {
			String msgId=request.getParameter("id");
			Integer msg_id = Integer.parseInt(msgId);
			MessagesDao messagesdao = new MessagesDaoImp();
			
			if(messagesdao.update_status(msg_id)){
				response.setStatus(200);
			}else {
				response.setStatus(202);
			}
		}
		request.getRequestDispatcher("welcomes/welcomesg.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

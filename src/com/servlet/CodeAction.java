package com.servlet;
import com.utils.Constants;
import com.utils.Globle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class CodeAction
 */
@WebServlet("/code.jhtml")
public class CodeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String code="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedImage image=new BufferedImage(Constants.IMAGE_WIDTH,Constants.IMAGE_HEIGHT,BufferedImage.TYPE_INT_RGB);
		ServletOutputStream sos=response.getOutputStream();
		Graphics g=image.getGraphics();
		g.fillRect(0,0,Constants.IMAGE_WIDTH,Constants.IMAGE_HEIGHT);
		for(int i=0;i<4;i++){
			drawCode(g,i);
		}
		ImageIO.write(image,"GIF",sos);
		Globle.setCode(this.code);
		this.code="";
		sos.close();
	}
	    	private void drawCode(Graphics graphics, int i){
		        char[] chr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
		        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
		        ,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
		        'q','r','s','t','u','v','w','x','y','z'};
		        Random random = new Random();
		        String number = "";
		        number=number+ chr[random.nextInt(62)];
				graphics.setFont(Constants.codeFont[i]);
				graphics.setColor(Constants.color[i]);
				graphics.drawString(number,20+i*20,30);
				this.code+=number;
				
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

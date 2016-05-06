package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessageDAO;
import entity.Message;

public class Send extends HttpServlet {

		public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String content = request.getParameter("content");
			String sendId = request.getParameter("sendId");
			String receiverId = request.getParameter("receiverId");
			String sendName = request.getParameter("sendName");
			MessageDAO dao = new MessageDAO();
			Message msg = new Message(Long.parseLong(sendId),sendName,
					Long.parseLong(receiverId),content,1);
			try {
				dao.saveMessage(msg);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			out.println("...");
		
		
	}

}

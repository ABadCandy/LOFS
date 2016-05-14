package com.pack.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.pack.dao.MessageDAO;
import com.pack.entity.Message;

public class Receive extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("receive service...");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("receiverId");
        MessageDAO dao = new MessageDAO();
        try {
            List<Message> msgs = dao.find(Long.parseLong(id));
            JSONArray array = JSONArray.fromObject(msgs);
            out.println(array.toString());
            out.close();
            dao.update(Long.parseLong(id));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

    }

}

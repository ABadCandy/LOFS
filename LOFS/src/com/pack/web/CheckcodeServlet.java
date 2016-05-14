package com.pack.web;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 该方法为验证码检测技术，用户需输入验证码进行验证后方可继续注册
 * 
 * @author tanghao
 * @date:日期:2016-5-1时间:中午12:33:14
 * @version 2.0
 */
public class CheckcodeServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        BufferedImage image = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random r = new Random();
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g.fillRect(0, 0, 60, 20);
        g.setColor(new Color(0, 0, 0));
        String number = String.valueOf(r.nextInt(99999));
        HttpSession session = request.getSession();
        session.setAttribute("number", number);
        g.drawString(number, 5, 15);
        g.drawLine(r.nextInt(60), r.nextInt(20), r.nextInt(60), r.nextInt(20));
        g.drawLine(r.nextInt(60), r.nextInt(20), r.nextInt(60), r.nextInt(20));
        g.drawLine(r.nextInt(60), r.nextInt(20), r.nextInt(60), r.nextInt(20));
        OutputStream os = response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
        encoder.encode(image);

    }

}

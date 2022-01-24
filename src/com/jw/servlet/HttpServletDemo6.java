package com.jw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo6")
public class HttpServletDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String header = req.getHeader("User-Agent");

        //判断客户端是什么类型的浏览器：Edge、OPR、Chrome、Safari、Firefox、IE浏览器或其它
        if (header.contains("Edge")){
            writer.println("Edge 浏览器");
        }else if (header.contains("Chrome")){
            writer.println("Chrome浏览器");
        }else if (header.contains("Safari")){
            writer.println("safari 浏览器");
        }else if (header.contains("Firefox")){
            writer.println("Firefox 浏览器");
        }else if (header.contains("IE")){
            writer.println("IE浏览器");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

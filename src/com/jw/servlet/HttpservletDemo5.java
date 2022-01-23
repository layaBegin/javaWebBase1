package com.jw.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/demo5")
public class HttpservletDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("getRequestURI:"+req.getRequestURI()+"<hr/>");
        writer.println("getParameter username:"+req.getParameter("username")+"<hr/>");
        writer.println("getMethod:"+req.getMethod()+"<hr/>");
        writer.println("Authorization:"+req.getHeader("Authorization")+"<hr/>");
        writer.println("getProtocol:"+req.getProtocol()+"<hr/>");
        writer.println("=================");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String nextElement = headerNames.nextElement();
            writer.println(nextElement+":"+req.getHeader(nextElement) + "<hr/>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

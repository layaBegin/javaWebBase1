package com.jw.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Enumeration;

public class HttpServletDemo4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = getInitParameter("name");
        String age = getInitParameter("age");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("name:"+name);
        writer.println("age:"+age);

        Enumeration<String> names = getInitParameterNames();
        while (names.hasMoreElements()){
            String s = names.nextElement();
            writer.println("<hr/>");
            writer.println(s +":" + getInitParameter(s));

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
        System.out.println(new Timestamp(System.currentTimeMillis()) + "==初始化");
    }
}

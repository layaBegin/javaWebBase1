package com.jw.servlet;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.IOUtils;

//@WebServlet("/demo12")
public class TestServletContext extends HttpServlet {
    ServletContext application;
    @Override
    public void init() throws ServletException {
        application = getServletContext();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        application.setAttribute("count",atomicInteger);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html; charset=UTF-8");
//        ServletContext servletContext = getServletContext();
//        String user = (String)servletContext.getInitParameter("user");
//        String child = (String)servletContext.getInitParameter("child");
//        PrintWriter writer = resp.getWriter();
//        writer.println("全局参数user:" + user);
//        writer.println("child:"+child);
//        String user1 = getInitParameter("user");
//        writer.println("局部参数user：" + user1);

        /*ServletContext application = getServletContext();
        InputStream resourceAsStream = application.getResourceAsStream("/img/0.jpg");
        ServletOutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(resourceAsStream, outputStream);

        String realPath = application.getRealPath("/img/0.jpg");
        System.out.println("realPath:" + realPath);*/


        AtomicInteger atomicInteger = (AtomicInteger)application.getAttribute("count");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        if ("Jack".equals(username) && "123".equals(password)){
            Integer count = atomicInteger.getAndIncrement();
            writer.println("登录成功,你是第" + count +"个登录的");
        }else {
            writer.println("登录失败。<a href=login.html>请重试</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}


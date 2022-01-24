package com.jw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo10")
public class TestRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*
        1. 地址栏变化了，显示的是新的地址
        2. 请求次数有2次
        3. 请求域中的数据丢失了，因为是2次请求
         */
        req.setCharacterEncoding("utf-8");
        req.setAttribute("username","孙悟空");
        String contextPath = req.getContextPath();
        System.out.println("contentPath:"+ contextPath);
        resp.sendRedirect(contextPath + "/two");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

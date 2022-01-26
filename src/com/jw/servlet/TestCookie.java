package com.jw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie")
public class TestCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //2. 设置Cookie过期的时间，设置为10分钟以后过期

//        1. 正整数：以秒为单位设置过期的时间
//        2. 零：表示删除这个Cookie
//        3. 负整数：无效，浏览器关闭就过期

//        Cookie cookie = new Cookie("username","张三");
//        cookie.setPath(req.getContextPath()+"/cookie1");
//        cookie.setMaxAge(60 * 10);
//        resp.addCookie(cookie);
//        Cookie cookie1 = new Cookie("username1","lishi");
//        cookie1.setMaxAge(60 * 20);
//        resp.addCookie(cookie1);

//        System.out.println("===服务器返回cookie");
//        resp.setContentType("text/html; charset=UTF-8");
        //获取cookie信息
//        resp.setContentType("text/html; charset=UTF-8");
//        PrintWriter writer = resp.getWriter();
//        Cookie[] cookies = req.getCookies();
//        for (Cookie c :
//                cookies) {
//            String name = c.getName();
//            String value = c.getValue();
//            writer.println(name+ ":"+value);
//        }

        //req.getRequestDispatcher("/cookie1").forward(req,resp);

        //删除cookie
        Cookie cookie = new Cookie("username",null);
        cookie.setMaxAge(0);
        cookie.setPath(req.getContextPath() + "/cookie");
        resp.addCookie(cookie);

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("cookie被删除了");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doGet(req, resp);
    }
}

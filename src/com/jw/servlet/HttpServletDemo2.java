package com.jw.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * 1. 编写一个类继承于HttpServlet
 * 2. 重写doGet或doPost方法
 * 3. 使用xml或注解的方式配置Servlet的访问地址
 *
 * @WebServlet注解
 *  value属性：访问地址，必须以/开头
 *  name属性：Servlet的名字，不能同名
 *  urlPatterns属性：功能与value一样
 @WebServlet(name="demo2",urlPatterns = "/demo2")

 如果路径前面没有/，错误信息：
 Caused by: java.lang.IllegalArgumentException: Invalid <url-pattern> [demo2] in servlet mapping
 *
 */
//@WebServlet({"/demo2","/demo200"})
//@WebServlet(urlPatterns = {"/demo2","/demo200","/demo2000"})
@WebServlet("/demo2")
public class HttpServletDemo2  extends HttpServlet {

    /**
     * 初始化的方法：Tomcat创建Servlet对象以后，执行的方法，只会执行1次
     * Servlet在Tomcat中是单例模式，一个类永远只有一个对象
     * 用户第1次访问的时候创建这个对象
     * @param config 配置对象
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        //输出现在的时间
        System.out.println(new Timestamp(System.currentTimeMillis()) + " 初始化====");
    }

    /**
     * 服务的方法: 每次请求都会执行，执行多次
     * @param request 请求对象
     * @param response 响应对象
     */
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        HttpServletResponse resp = (HttpServletResponse)response;
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>服务的方法: 每次请求都会执行，执行多次service</h1>");
        System.out.println(new Timestamp(System.currentTimeMillis()) + " 执行服务的方法===");
    }


    /**
     * 销毁的方法：服务器关闭的时候，销毁Servlet的时候执行1次
     * Servlet是常驻内存的，只要服务器不关闭就一直存在
     */
    @Override
    public void destroy() {
        System.out.println(new Timestamp(System.currentTimeMillis()) + " 执行销毁的方法==");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>注解方式配置servlet，servlet</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

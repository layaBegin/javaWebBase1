package com.jw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//请求域
@WebServlet("/demo9")
public class TestRequestAera extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //向请求域中添加键和值，参数1：字符串类型名字 参数2：Object类型的值
        request.setAttribute("username","孙悟空");  //自动向上转型
        //删除请求域中数据
        //request.removeAttribute("username");
        //从请求域通过值中取出值
        //String username = (String) request.getAttribute("username");  //强制向下转型
        //输出到页面
       /* response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("===请求域中用户数据：" + username);*/
       //转发
        /*
        1. 地址栏不会发生变化，显示的还是上一个Servlet的地址
        2. 只有一次请求
        3. 请求域中数据不会丢失，因为是同一次请求
         */
       request.getRequestDispatcher("two").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

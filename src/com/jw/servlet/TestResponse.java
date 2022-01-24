package com.jw.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

@WebServlet("/demo11")
public class TestResponse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //resp.sendError(406,"你吃了吗");
        //resp.setHeader("refresh","3;http://www.baidu.com");

        /*
        1. 只设置location响应头
        2. 同时设置302状态码
        3. 使用重定向的方法跳转
        */
        //resp.setHeader("location","testWelcom.html");
        //resp.setStatus(302);
        //resp.sendRedirect("testWelcom.html");

        //压缩
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ddsfewr[twjferwpvrjgrtbjerv");

        resp.setHeader("content-encoding","gzip");
        ServletOutputStream outputStream = resp.getOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
        gzipOutputStream.write(stringBuilder.toString().getBytes());
        gzipOutputStream.finish();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

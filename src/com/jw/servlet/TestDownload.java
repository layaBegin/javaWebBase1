package com.jw.servlet;


import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet("/down")
public class TestDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        //attachment 附件下载
        //resp.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(filename,"utf-8"));
        //inline: 在线打开，默认值
        resp.setHeader("Content-Disposition","inline;filename=" + URLEncoder.encode(filename,"utf-8"));

        ServletContext application = getServletContext();
        InputStream inputStream = application.getResourceAsStream("/download/" + filename);
        ServletOutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(inputStream, outputStream);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doGet(req, resp);
    }
}

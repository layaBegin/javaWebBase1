package com.jw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/demo7")
public class HttpServletDemo7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String[] hobbies = req.getParameterValues("hobby");
        writer.println("您的爱好是：" + Arrays.toString(hobbies));
        Map<String, String[]> parameterMap = req.getParameterMap();
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String element = parameterNames.nextElement();
            writer.println(element + ":"+ req.getParameter(element)+"<br/>");
        }
        writer.println("<hr/>");
        for (Map.Entry<String, String[]> entry :
                parameterMap.entrySet()) {
            String[] values = entry.getValue();
            writer.println(entry.getKey() + ":"+ Arrays.toString(values)+"<br/>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

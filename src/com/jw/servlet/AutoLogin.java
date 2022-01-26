package com.jw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/autoLogin")
public class AutoLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");


        if ("Jack".equals(username) && "123".equals(password)){
            if ("on".equalsIgnoreCase(remember)){
                Cookie cUsername = new Cookie("username", username);
                Cookie cPassword = new Cookie("password", password);
                cUsername.setMaxAge(60 * 60 * 24 * 7);
                cPassword.setMaxAge(60 * 60 * 24 * 7);
                cUsername.setPath(req.getContextPath() );
                cPassword.setPath(req.getContextPath() );

                resp.addCookie(cUsername);
                resp.addCookie(cPassword);
            }

            resp.sendRedirect("success.html");
        }else {
            resp.sendRedirect("failure.html");
        }
        System.out.println("==username:" + username);
        System.out.println("==password:"+password);
        System.out.println("==remember:"+remember);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

package com.jw.servlet;

import com.jw.dao.UserDao;
import com.jw.dao.impl.UserDaoImpl;
import com.jw.entity.User;
import com.jw.service.LoginService;
import com.jw.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {

    UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        userDao = new UserDaoImpl();
        User user = userDao.selectOne(username, password);
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        if (user !=null){
            req.setAttribute("user",user);
            req.getRequestDispatcher("two").forward(req,resp);
        }else {
            writer.println("登录失败 ");
            resp.sendRedirect("testWelcom.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

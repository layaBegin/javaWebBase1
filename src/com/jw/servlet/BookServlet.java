package com.jw.servlet;

import com.jw.dao.impl.BookDaoImpl;
import com.jw.entity.Book;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


@WebServlet("/book")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String type = req.getParameter("type");
        System.out.println("name:"+name);
        System.out.println("author:"+author);
        System.out.println("type:"+type);
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setType(Integer.parseInt(type));
        book.setTime(new Date(System.currentTimeMillis()));
        BookDaoImpl bookDao = new BookDaoImpl();
        int count = bookDao.save(book);
        System.out.println("==count:" + count);
        String contextPath = req.getContextPath();
        if (count > 0){
            resp.sendRedirect("success.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

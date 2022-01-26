package com.jw.dao.impl;

import com.jw.dao.BookDao;
import com.jw.entity.Book;
import com.jw.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;

public class BookDaoImpl implements BookDao {

    @Override
    public int save(Book book) {
        SqlSession session = SqlSessionUtils.openSession();
        BookDao mapper = session.getMapper(BookDao.class);

        book.setTime(new Date(System.currentTimeMillis()));

        int num = mapper.save(book);

        //插入之后要提交
        session.commit();
        session.close();
        System.out.println("影响的行数：" + num);
        return num;
    }
}

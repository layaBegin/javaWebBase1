package com.jw.test;

import com.jw.dao.BookDao;
import com.jw.entity.Book;
import com.jw.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.helpers.DateTimeDateFormat;
import org.junit.Test;

import java.sql.Date;
import java.text.Format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBook {

    @Test
    public void test1(){
        SqlSession session = SqlSessionUtils.openSession();
        BookDao mapper = session.getMapper(BookDao.class);
        Book book = new Book();
        book.setName("三国演绎8");
        book.setAuthor("吴承恩8");
        book.setType(2);
        book.setTime(new Date(System.currentTimeMillis()));

        int num = mapper.save(book);

         //插入之后要提交
        session.commit();
        session.close();
        System.out.println("影响的行数：" + num);
    }
}

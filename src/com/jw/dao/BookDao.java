package com.jw.dao;

import com.jw.entity.Book;
import org.apache.ibatis.annotations.Insert;

public interface BookDao {


     @Insert("INSERT INTO book VALUES (null,#{name},#{author},#{time},#{type})")
     int save(Book book);
}

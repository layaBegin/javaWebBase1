package com.jw.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {

    static SqlSessionFactory factory;
    static {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            factory = sqlSessionFactoryBuilder.build(resourceAsStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession  openSession(){
        return factory.openSession();
    }

}

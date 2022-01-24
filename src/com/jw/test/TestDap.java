package com.jw.test;

import com.jw.dao.UserDao;
import com.jw.entity.User;
import com.jw.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;



public class TestDap {

    @Test
    public void testMysql(){
        SqlSession session = SqlSessionUtils.openSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User jack = mapper.selectOne("Jack", "123");
        System.out.println("jack:"+jack);

    }

}

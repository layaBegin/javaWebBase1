package com.jw.dao.impl;

import com.jw.dao.UserDao;
import com.jw.entity.User;
import com.jw.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements UserDao {
    @Override
    public User selectOne(String username, String password) {

        SqlSession session = SqlSessionUtils.openSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.selectOne(username, password);
        System.out.println("===user:"+user);
        session.close();
        return user;
    }
}

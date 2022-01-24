package com.jw.dao;

import com.jw.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao  {

    @Select("SELECT * FROM USER WHERE username=#{username} AND `password`=#{password}")
    public User selectOne(@Param("username") String username,@Param("password") String password);

}

package com.ltf.shop.mapper;

import com.ltf.shop.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Insert("INSERT INTO user(name,phone,create_time,age) VALUES(#{name}, #{phone}, #{createTime},#{age})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")   //keyProperty java对象的属性；keyColumn表示数据库的字段
    int insert(User user);

    @Select("select * from user")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    List<User> getAll();
}

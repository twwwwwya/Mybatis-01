package com.tangwei.dao;

import com.tangwei.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author:Ann
 * @date 2021/9/22  20:47
 */
public interface UserMapper {
    @Select("select * from user")
    List<User> getUserList();


    User getUserById(@Param("id") int id);


    //返回基本数据类型时需要使用包装类
    @Insert("insert into user(id,name,pwd) value (#{id},#{name},#{pwd})")
    Integer addUser(User user);

    @Update("update user set name=#{name},pwd= #{pwd} where id = #{id}")
    Integer updateUser(User user);

    @Delete("delete from user where id = #{id}")
    Integer deleteUserById(@Param("id") int id);
}

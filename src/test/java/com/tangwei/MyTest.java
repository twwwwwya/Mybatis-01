package com.tangwei;

import com.tangwei.dao.UserMapper;
import com.tangwei.pojo.User;
import com.tangwei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author:Ann
 * @date 2021/9/22  20:47
 */
public class MyTest {
    @Test
    public void getIserList(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        for (User user : mapper.getUserList()) {
            System.out.println(user);
        }


    }

    @Test
    public void getUserByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User userById = mapper.getUserById(2);

        System.out.println(userById);
    }

    @Test
    public void  addUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(2, "小红", "456");

        Integer integer = mapper.addUser(user);

        System.out.println(integer);

        sqlSession.commit();

        sqlSession.close();


    }
}

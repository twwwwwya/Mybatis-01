package com.tangwei.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author:Ann
 * @date 2021/9/19  16:28
 */
public class MybatisUtils {
//    提升作用域
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
//            获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) {
        SqlSession sqlSession = getSqlSession();
        System.out.println(sqlSession);
    }
}

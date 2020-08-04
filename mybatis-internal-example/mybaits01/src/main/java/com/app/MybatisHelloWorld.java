package com.app;

import com.pojo.Test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisHelloWorld {

    public static void main(String[] args) {
        String resource = "Configuration.xml";

        Reader read;
        try {
            read = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(read);
            SqlSession session = sqlSessionFactory.openSession();
            SqlSession session1 = sqlSessionFactory.openSession();
            try {
                Test o = (Test) session.selectOne("com.mapper.TestMapper.getTest", 1);
                System.out.println(o.getName());
                session.commit();
                Test o1 = (Test) session1.selectOne("com.mapper.TestMapper.getTest", 1);
                System.out.println(o1.getName());
            } finally {
                session.close();
                session1.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

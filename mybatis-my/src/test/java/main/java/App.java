import bean.Test;
import mapper.TestMapper;
import mybatis.session.SqlSession;
import mybatis.session.SqlSessionFactory;
import mybatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String resource = "Mybatis-config.xml";
        InputStream inputStream = App.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);
        System.out.println(sqlSessionFactory.getConfiguration().getJdbcProperties().getUrl());

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Test demo = null;
        List<Test> demos = null;

/*        //使用sqlSession直接查询
        demo = sqlSession.selectOne("mapper.TestMapper.getById",1L);
        System.out.println(demo);
        demos = sqlSession.selectList("mapper.TestMapper.getAll");
        System.out.println(demos);*/
        //使用Mapper
        TestMapper demoMapper = sqlSession.getMapper(TestMapper.class);
        demo = demoMapper.getById(1);
        System.out.println(demo);
        demos = demoMapper.getAll();
        System.out.println(demos);
    }
}

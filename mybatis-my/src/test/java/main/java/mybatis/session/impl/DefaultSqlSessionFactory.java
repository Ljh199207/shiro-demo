package mybatis.session.impl;

import mybatis.config.Configuration;
import mybatis.session.Executor;
import mybatis.session.SqlSession;
import mybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public SqlSession openSession() {
        Executor executor = new SimpleExecutor(configuration.getJdbcProperties());
        SqlSession sqlSession = new DefaultSqlSession(configuration, executor);
        return sqlSession;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}

package mybatis.session.impl;

import mybatis.config.Configuration;
import mybatis.session.Executor;
import mybatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.List;

public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        List<T> list = executor.query(configuration.getMapperStatement(statement), parameter);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public <E> List<E> selectList(String statement) {
        return executor.query(configuration.getMapperStatement(statement), null);

    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter) {
        return executor.query(configuration.getMapperStatement(statement), parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        T newProxyInstance = (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new MapperProxy(this));
        return newProxyInstance;
    }
}

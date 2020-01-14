package mybatis.session;

import mybatis.config.Configuration;

/**
 * SqlSessionFactory主要是管理SqlSession
 */
public interface SqlSessionFactory {

    public Configuration getConfiguration();

    public SqlSession openSession();
}

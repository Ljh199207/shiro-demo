package mybatis.session;

import java.util.List;

/**
 * SqlSession主要是进行数据库操作的。
 */
public interface SqlSession {
    <T> T selectOne(String statement, Object parameter);
    <E> List<E> selectList(String statement);
    <E> List<E> selectList(String statement, Object parameter);
    <T> T getMapper(Class<T> type);
}

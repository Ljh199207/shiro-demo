package mybatis.session;

import mybatis.config.MapperStatement;

import java.util.List;

public interface Executor {
    <E> List<E> query(MapperStatement ms, Object parameter);
}

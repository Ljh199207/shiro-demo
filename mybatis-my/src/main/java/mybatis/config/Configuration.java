package mybatis.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration这里就是统一进行管理配置以及提供一些对配置基本的操作方法。
 */
public class Configuration {
    private mybatis.config.JdbcProperties jdbcProperties;
    private Map<String, mybatis.config.MapperStatement> mapperMap = new HashMap<String, mybatis.config.MapperStatement>();

    public void addMapperStatement(mybatis.config.MapperStatement mapperStatement) {
        mapperMap.put(mapperStatement.getId(), mapperStatement);
    }

    public mybatis.config.MapperStatement getMapperStatement(String id) {
        return mapperMap.get(id);
    }

    public mybatis.config.JdbcProperties getJdbcProperties() {
        return jdbcProperties;
    }

    public void setJdbcProperties(mybatis.config.JdbcProperties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }
}

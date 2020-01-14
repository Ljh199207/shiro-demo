package mybatis.config;

/**
 * 我们使用JdbcProperties进行存储数据库相关的信息，
 * 使用MapperStatement存储mapper.xml对应的配置信息，
 * 使用Configuration进行统一的管理mybatis-config.xml配置信息
 */
public class JdbcProperties {
    private String url;
    private String driver;
    private String username;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

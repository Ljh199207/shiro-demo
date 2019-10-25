import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class LoginLogoutTest {

    @Test
    public void testHelloworld() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager instance = factory.getInstance();
        SecurityUtils.setSecurityManager(instance);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        System.out.println(token.toString());

        subject.login(token);
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        subject.logout();
    }

    @Test
    public void testCustomRealm() {
        //第一步，获取SecurityManger
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        //2 获取securityManger 的实例
        SecurityManager security = factory.getInstance();
        //3获取SecurityUtil
        SecurityUtils.setSecurityManager(security);
        //4获取subject
        Subject subject = SecurityUtils.getSubject();
        //获取token
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
        subject.login(token);
        Assert.assertEquals(true,subject.isAuthenticated());
        subject.logout();
    }
    @Test
    public void testCustomMultiRealm(){
        //第一步，获取SecurityManger
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");
        //2 获取securityManger 的实例
        SecurityManager security = factory.getInstance();
        //3获取SecurityUtil
        SecurityUtils.setSecurityManager(security);
        //4获取subject
        Subject subject = SecurityUtils.getSubject();
        //获取token
        UsernamePasswordToken token = new UsernamePasswordToken("wang1","123");
        subject.login(token);
        Assert.assertEquals(true,subject.isAuthenticated());
        subject.logout();
    }

    @Test
    public void testJdbcReal(){

        Factory<SecurityManager> factory = new IniSecurityManagerFactory();
        SecurityManager instance = factory.getInstance();
        JdbcRealm realm = new JdbcRealm();
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("mysql://localhost:3306/shiro");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        realm.setDataSource(dataSource);
        realm.setPermissionsLookupEnabled(true);
        /*Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        SecurityManager instance = factory.getInstance();*/
        SecurityUtils.setSecurityManager(instance);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
        subject.login(token);
        Assert.assertEquals(true,subject.isAuthenticated());
        subject.logout();
    }
}

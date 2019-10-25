package realm.role;

import org.junit.Assert;
import org.junit.Test;

public class PermissionTest extends BaseTest {
    @Test
    public void testIsPermitted() {
        //  Shiro提供了isPermitted和isPermittedAll用于判断用户是否拥有某个权限或所有权限
        login("classpath:shiro-permission.ini", "zhang", "123");
        //判断拥有权限：user:create
        Assert.assertTrue(subject().isPermitted("user:create"));
        //判断拥有权限：user:update and user:delete
        Assert.assertTrue(subject().isPermittedAll("user:update", "user:delete"));
        //判断没有权限：user:view
        Assert.assertFalse(subject().isPermitted("user:view"));
    }

    @Test
    public void testPermission() {
        login("classpath:shiro-permission.ini", "zhang", "123");
        subject().checkPermission("user:create");
        subject().checkPermissions("user:create","user:delete");
        //扔异常
        subject().checkPermissions("user:view");
    }
    @Test
    public void testWildcardPermission1() {
        login("classpath:shiro-permission.ini", "li", "123");
        subject().checkPermission("system:user:update");
        subject().checkPermissions("system:user:delete","system:user:update");
        subject().checkPermissions("system:user:update,delete");
    }

}

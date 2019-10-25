package realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author ljh
 * @date 2019/10/8 16:31
 */
public class MyRealm2  implements Realm {

    public String getName() {
        return "myrealm2";
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //得到用户名
        String username = (String)token.getPrincipal();
        //得到密码
        String password = new String((char[]) token.getCredentials());
        if(!"wang".equals(username)) {
            //如果用户名错误
            throw new UnknownAccountException();
        }
        if(!"123".endsWith(password)){
            //如果密码错误
            throw new IncorrectCredentialsException();
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}

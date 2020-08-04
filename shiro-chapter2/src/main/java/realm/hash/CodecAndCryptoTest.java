package realm.hash;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.junit.Assert;
import org.junit.Test;
import realm.role.BaseTest;

/**
 * @author ljh
 */
public class CodecAndCryptoTest extends BaseTest {

    @Test
    public void testBase64() {
        // base64编码/解码
        String str = "hello";
        String base64Encoded = Base64.encodeToString(str.getBytes());
        System.out.println(base64Encoded);
        String str2 = Base64.decodeToString(base64Encoded);
        System.out.println(str2);
        Assert.assertEquals(str, str2);

    }

    @Test
    public void testHex() {
        //16进制字符串编码/解码
        String str = "hello";
        String base64Encoded = Hex.encodeToString(str.getBytes());
        System.out.println(base64Encoded);
        String str2 = new String(Hex.decode(base64Encoded.getBytes()));
        Assert.assertEquals(str, str2);
    }

    @Test
    public void testHash() {
        //散列算法
        String str = "hello";
        String salt = "123";
        String md5 = new Md5Hash(str, salt).toString();
        System.out.println(md5);
    }

    @Test
    public void testSha1() {
        String str = "hello";
        String salt = "123";
        String sha1 = new Sha1Hash(str, salt).toString();
        System.out.println(sha1);

    }

}

package com.example.springredis.redis;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author ljh
 * @date 2019-11-26 16:31
 */
@SpringBootTest
public class RedisListTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void Lpush() {
        String list1 = "list1";
        String list2 = "list2";
        String list3 = "list3";
        String list4 = "list4";
        String key = "key";
        redisTemplate.delete(key);
        redisTemplate.opsForList().leftPush(key, list1);
        redisTemplate.opsForList().leftPush(key, list2);
        redisTemplate.opsForList().leftPush(key, list3);
        redisTemplate.opsForList().leftPush(key, list4);
        System.out.println(redisTemplate.opsForList().range(key, 0, -1));
    }

    @Test
    public void Lpushtrim() {
        String list1 = "list1";
        String list2 = "list2";
        String list3 = "list3";
        String list4 = "list4";
        String key = "key";
        redisTemplate.delete(key);
        redisTemplate.opsForList().leftPush(key, list1);
        redisTemplate.opsForList().leftPush(key, list2);
        redisTemplate.opsForList().leftPush(key, list3);
        redisTemplate.opsForList().leftPush(key, list4);
        //redisTemplate.opsForList().trim(key, 0, 1);
        System.out.println(redisTemplate.opsForList().range(key, 0, -1));
        System.out.println(redisTemplate.opsForList().size(key));
    }

    @Test
    public void testRightPopAndLeftPushTimeOut() {
        ListOperations<String, Object> opsForList = redisTemplate.opsForList();
        //与RightPopAndLeftPush相似，只是添加了超时机制
        //下面用一个简单的小故事呈现一下超时机制
        redisTemplate.delete("li20");
        redisTemplate.delete("li21");
        try {
            System.out.println("一天，li21来找li20还钱。");
            Thread.sleep(3000);
            System.out.println("但是li20当时身上所有资产的个数为：" + opsForList.size("li20") + "个，怎么可能有钱还");
            Thread.sleep(5000);
            System.out.println("而此时li21身上的资产个数为" + opsForList.size("li21") + "个，他一分钱都没有，他是真的缺钱！");
            Thread.sleep(5000);
            System.out.println("li20让li21等一会儿试试，也许某个傻逼程序员会施舍个东西给他，到时候就拿那个东西给li21还债！li21决定等上5秒试试。");
            Thread.sleep(7000);
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for (int i = 5; i > 0; i--) {
                        try {
                            Thread.sleep(1000);
                            System.out.println(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
            opsForList.rightPopAndLeftPush("li20", "li21", 5, TimeUnit.SECONDS);
            Thread.sleep(1000);
            System.out.println("5秒后，li21什么都没等到。此时li21的资产个数为：" + opsForList.size("li21") + "个，li20的资产个数为：" + opsForList.size("li20") + "个。li20让他再等15秒试试。li21答应了！");
            Thread.sleep(7000);
            Runnable runnable1 = new Runnable() {
                @Override
                public void run() {
                    for (int i = 15; i > 0; i--) {
                        try {
                            Thread.sleep(1000);
                            if (i == 11) {
                                System.out.println("果真，还没到15秒，傻逼程序员真来了！还塞给了li20一个a");
                                Thread.sleep(5000);
                                opsForList.rightPush("li20", "a");
                                System.out.println("这个时候，li20把他唯一一个元素a给了li21");
                                return;
                            } else {
                                System.out.println(i);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            };
            Thread thread1 = new Thread(runnable1);
            thread1.start();
            opsForList.rightPopAndLeftPush("li20", "li21", 20, TimeUnit.SECONDS);
            Thread.sleep(5000);
            System.out.println("现在li20身上的元素有" + opsForList.size("li20") + "个，而li21得到了" + opsForList.range("li21", 0, 0) + ",资产变成了" + opsForList.size("li21") + "个！");
            Thread.sleep(5000);
            System.out.println("现在li20又变得一贫如洗了，当然，可以看出，他是一个言而有信的人！li20心想：傻逼程序员真的是傻逼程序员！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

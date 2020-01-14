package com.example;

import com.example.springbootmybits.jpa.entity.*;
import com.example.springbootmybits.jpa.repository.*;
import com.example.springbootmybits.mybatis.bean.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybitsApplicationTests {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityManager entityManager;


    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        Student student = new Student();
        student.setSno("110");
        student.setName("你知道的");
        student.setSex("1");
        ValueOperations<String, Student> operations = redisTemplate.opsForValue();
        operations.set("student1", student);
        operations.set("student2", student, 1, TimeUnit.SECONDS);
        //Thread.sleep(1000);
        boolean exists = redisTemplate.hasKey("student2");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }

    @Test
    public void textSave() {
        People user = new People();
        user.setSex("1");
        user.setBirthday(LocalDateTime.now());
        user.setName("小三");
        People userResult = peopleRepository.save(user);
        System.out.println(userResult);
    }

    @Test
    public void textSaveoneToMany() {
        Author author = new Author();
        Author author1 = new Author();
        author.setName("作者1");
        author1.setName("作者2");
        Author save = authorRepository.save(author);
        Author save1 = authorRepository.save(author1);
        Article article = new Article();
        Article article1 = new Article();
        article.setContent("这个内容比较多");
        article.setTitle("title1");
        article.setAuthor(save);

        article1.setContent("这个内容比较多");
        article1.setTitle("title1");
        article1.setAuthor(save);

        article = articleRepository.save(article);
        article1 = articleRepository.save(article1);
        System.out.println(save);

    }

    @Test
    public void delete() {
        Author author = authorRepository.findAuthorByName("作者1");
        System.out.println(author);
        authorRepository.delete(author.getId());
    }


    @Test
    public void ManyToManySave() {
        Authority authority = new Authority();
        authority.setName("ROLE_ADMIN");
        authorityRepository.save(authority);
    }

    @Test
    public void saveUser() {
        Authority authority = new Authority();
        authority.setName("ROLE_ADMIN");
        authorityRepository.save(authority);
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        List<Authority> authorityList = new ArrayList<>();
        authorityList.add(authority);
        user.setAuthorityList(authorityList);
        userRepository.save(user);

        User user1 = userRepository.findByName("ad");
        System.out.println(user1.getId() + user1.getUsername());

        Integer user2 = userRepository.updateUser2(user1.getId(), "ADMIN", "ABCD");
        System.out.println(user2);
    }

    @Test
    public void NativeQuery() {
    }


}

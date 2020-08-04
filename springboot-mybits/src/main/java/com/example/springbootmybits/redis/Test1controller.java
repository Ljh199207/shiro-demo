package com.example.springbootmybits.redis;

import com.example.springbootmybits.mybatis.bean.Student;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author user
 */
@RestController
public class Test1controller {

    @RequestMapping("/getStudent")
    @Cacheable(value = "user-key", keyGenerator = "keyGenerator")
    public Student queryStudentBySno(String userName) {
        Student student = new Student();
        student.setSno("110");
        student.setName("你知道的");
        student.setSex("1");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return student;
    }

    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}

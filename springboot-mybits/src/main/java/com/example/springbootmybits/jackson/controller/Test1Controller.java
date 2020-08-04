package com.example.springbootmybits.jackson.controller;

import com.example.springbootmybits.jackson.pojo.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;

/**
 * @author ljh
 * @date 2019-11-18 11:35
 */
@Controller
public class Test1Controller {
    @Autowired
    ObjectMapper mapper;

    @RequestMapping("getuser")
    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setUserName("mrbird");
        user.setBirthday(new Date());
        return user;
    }


    @RequestMapping("serialization")
    @ResponseBody
    public String serialization() {
        try {
            User user = new User();
            user.setUserName("mrbird");
            user.setBirthday(new Date());
            String str = mapper.writeValueAsString(user);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 树序列化
     *
     * @return
     */
    @RequestMapping("readjsonstring")
    @ResponseBody
    public String readJsonString() {
        try {
            String json = "{\"name\":\"mrbird\",\"age\":26}";
            JsonNode node = this.mapper.readTree(json);
            String name = node.get("name").asText();
            int age = node.get("age").asInt();
            return name + " " + age;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("readjson2string")
    @ResponseBody
    public String readJson2String() throws IOException {
        String json = "{\"name\":\"mrbird\",\"hobby\":{\"first\":\"sleep\",\"second\":\"eat\"}}";
        ;
        JsonNode node = this.mapper.readTree(json);
        JsonNode hobby = node.get("hobby");
        String first = hobby.get("first").asText();
        return first;
    }

    @RequestMapping("readjsonasobject")
    @ResponseBody
    public String readJsonAsObject() {
        try {
            String json = "{\"userName\":\"mrbird\",\"age\":26}";
            User user = mapper.readValue(json, User.class);
            String name = user.getUserName();
            int age = user.getAge();
            return name + " " + age;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

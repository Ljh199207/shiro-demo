package com.example.springbootmybits.jackson.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ljh
 * @date 2019-11-18 11:35
 * @JsonProperty，作用在属性上，用来为JSON Key指定一个别名。
 * @Jsonlgnore，作用在属性上，用来忽略此属性。
 * @JsonIgnoreProperties，忽略一组属性，作用于类上，比如JsonIgnoreProperties({ "password", "age" })。
 * @JsonFormat，用于日期格式化
 * @JsonNaming，用于指定一个命名策略，作用于类或者属性上。Jackson自带了多种命名策略，你可以实现自己的命名策略，比如输出的key 由Java命名方式转为下面线命名方法
 */
@Data
//@JsonIgnoreProperties({"password","age"})
@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
public class User implements Serializable {
    private static final long serialVersionUID = 6222176558369919436L;

    private String userName;

    private int age;
    //@JsonIgnore
    private String password;

    @JsonProperty("bth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}

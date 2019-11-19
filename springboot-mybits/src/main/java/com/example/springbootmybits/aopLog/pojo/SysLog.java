package com.example.springbootmybits.aopLog.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ljh
 * @date 2019-11-14 14:30
 */
@Data
public class SysLog implements Serializable {
    private static final long serialVersionUID = -6309732882044872298L;

    private Integer id;
    private String username;
    private String operation;
    private Integer time;
    private String method;
    private String params;
    private String ip;
    private Date createTime;
}

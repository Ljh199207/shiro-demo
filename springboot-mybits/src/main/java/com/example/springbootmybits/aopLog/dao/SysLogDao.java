package com.example.springbootmybits.aopLog.dao;

import com.example.springbootmybits.aopLog.pojo.SysLog;

/**
 * @author ljh
 * @date 2019-11-14 14:32
 */
public interface SysLogDao {
    void saveSysLog(SysLog syslog);
}

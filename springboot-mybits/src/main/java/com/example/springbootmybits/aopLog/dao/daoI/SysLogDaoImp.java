package com.example.springbootmybits.aopLog.dao.daoI;

import com.example.springbootmybits.aopLog.dao.SysLogDao;
import com.example.springbootmybits.aopLog.pojo.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author ljh
 * @date 2019-11-14 14:33
 */
@Repository
public class SysLogDaoImp implements SysLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveSysLog(SysLog syslog) {
        StringBuffer sql = new StringBuffer("insert into sys_log ");
        sql.append("(id,username,operation,time,method,params,ip,create_time) ");
        sql.append("values(seq_sys_log.nextval,:username,:operation,:time,:method,");
        sql.append(":params,:ip,:createTime)");

        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        npjt.update(sql.toString(), new BeanPropertySqlParameterSource(syslog));
    }
}

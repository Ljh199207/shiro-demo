package com.example.springbootmybits.jpa.repository;

import com.example.springbootmybits.jpa.entity.People;
import com.example.springbootmybits.jpa.vo.PeopleVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface PeopleRepository extends JpaRepository<People, Long>, JpaSpecificationExecutor<People> {

    @Query(value = "select p.NAME,p.SEX,p.BIRTHDAY from PEOPLE p LEFT JOIN ADDRESS a on p.ADDRESS_ID = a.ID where p.name like %:name% ", nativeQuery = true)
    Object[] findAllDetail(@Param("name") String name);


    /**
     * 返回List<Map>信息
     *
     * @param realName
     * @return
     */
    @Query(value = "select new map(p as people) from People p where  p.name like %:name%")
    List<Map<String, Object>> getUserByRealName(@Param("name") String realName);

    /**
     * 返回map对象
     * @param realName
     * @return
     */
    //@Query(value = "select new map(p.name  ,p.sex  ,p.birthday ,a.phone,a.address) from People p left join Address a on p.address = a.id where p.name like %:name%")
    // List<Map<String, Object>>  getUserByRealName1(@Param("name") String realName);

}

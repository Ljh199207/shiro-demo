package com.example.springbootmybits.jpa.repository;

import com.example.springbootmybits.jpa.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AuthorRepository extends JpaRepository<Author,Long>, JpaSpecificationExecutor<Author> {


   // find+全局修饰+By+实体属性名称+限定词+连接词+（其他实体属性）+OrderBy+排序属性+排序方向
    Author  findAuthorByName(String name);

}

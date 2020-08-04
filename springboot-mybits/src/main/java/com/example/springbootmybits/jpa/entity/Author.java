package com.example.springbootmybits.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
public class Author {
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.AUTO) // 自增长策略
    private Long id; //id
    @NotEmpty(message = "姓名不能为空")

    @Size(min = 2, max = 20)
    @Column(nullable = false, length = 20)
    private String name;//姓名

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Article> articleList;
}

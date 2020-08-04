package com.example.springbootmybits.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // 自增长策略
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "标题不能为空")
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50) // 映射为字段，值不能为空
    private String title;
    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    // @Basic(fetch = FetchType.LAZY) // 懒加载
    @NotEmpty(message = "内容不能为空")
    @Size(min = 2)
    @Column(nullable = false) // 映射为字段，值不能为空
    private String content;//文章全文内容

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    public Author author;

}

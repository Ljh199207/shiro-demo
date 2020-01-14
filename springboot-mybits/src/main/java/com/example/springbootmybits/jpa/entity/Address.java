package com.example.springbootmybits.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "phone", nullable = true, length = 11)
    private String phone;//手机

    @Column(name = "zipcode", nullable = true, length = 6)
    private String zipcode;//邮政编码

    @Column(name = "address", nullable = true, length = 100)
    private String address;//地址
}


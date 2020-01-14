package com.example.springbootmybits.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;//id

    @Column(name = "name",length = 20)
    private String name;

    @Column(name = "sex",length = 1)
    private String sex;//性别

    @Column(name = "birthday")
    private LocalDateTime birthday;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public People() {
    }
}

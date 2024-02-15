package ru.home.monolithomeproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2,max = 15)
    @Column(nullable = false)
    private String name;

    @NotNull
    @Size(min = 2,max = 50)
    @Column(nullable = false)
    private String surName;

    @Lob
    private byte[] avatar;

    @NotNull
    private String fileName;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

}

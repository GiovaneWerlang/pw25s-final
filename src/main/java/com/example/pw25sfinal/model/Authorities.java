package com.example.pw25sfinal.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String authority;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Users> users;
}

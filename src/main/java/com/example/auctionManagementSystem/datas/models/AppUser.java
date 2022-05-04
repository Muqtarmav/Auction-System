package com.example.auctionManagementSystem.datas.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String mobile;



    private String nation;
    private String age;
    private String passWord;

}

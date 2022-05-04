package com.example.auctionManagementSystem.service;

import com.example.auctionManagementSystem.datas.models.AppUser;

import java.util.List;

public interface AppUserService {

    List<AppUser> findAll();
    AppUser createUser(AppUser appUser);
    AppUser findById(Long id);
    AppUser updateUser(String email);
    void delete(AppUser appUser);
    void delete(Long  id);

}

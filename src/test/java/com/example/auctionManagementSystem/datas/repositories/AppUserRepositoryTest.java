package com.example.auctionManagementSystem.datas.repositories;

import com.example.auctionManagementSystem.datas.models.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
class AppUserRepositoryTest {


    @Autowired
    AppUserRepository appUserRepository;

    @BeforeEach
    void setUp() {
    }


    @Test
    @DisplayName("user can be saved")

    void appUserCanBeSavedInDatabaseTest(){
        AppUser appUser = new AppUser();
        appUser.setFirstName("ade");
        appUser.setLastName("tola");
        appUser.setEmail("adetola@gmail.com");
        appUser.setMobile("27873892");
        appUser.setNation("Nigeria");
        appUser.setAge("22");
        log.info("user is saved ::{}", appUser);
        appUserRepository.save(appUser);

        assertThat(appUser.getFirstName()).isEqualTo("ade");
        assertThat(appUser.getLastName()).isEqualTo("tola");
        assertThat(appUser.getEmail()).isEqualTo("adetola@gmail.com");
        assertThat(appUser.getMobile()).isEqualTo("27873892");
        assertThat(appUser.getNation()).isEqualTo("Nigeria");
        assertThat(appUser.getAge()).isEqualTo("22");

    }



    @Test
    @DisplayName("all user can be find in database")

    void AllUserCanBeFoundInDatabase(){

        List<AppUser> user = appUserRepository.findAll();
        assertThat(user).isNotNull();
        assertThat(user.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("find user By Id")

    void findUserByIdTest(){

        AppUser appUser = appUserRepository.findById(3L).orElse(null);
        assertThat(appUser).isNotNull();
        assertThat(appUser.getFirstName()).isEqualTo("ade");
        assertThat(appUser.getLastName()).isEqualTo("tola");
        assertThat(appUser.getEmail()).isEqualTo("adetola@gmail.com");
        assertThat(appUser.getNation()).isEqualTo("Nigeria");
        assertThat(appUser.getId()).isEqualTo(3);

        log.info("user is retrieved ::{}", appUser);
    }


    @Test
    @DisplayName("user can be deleted")

    void appUserCanBeDeleted(){
        AppUser appUser = new AppUser();
        appUserRepository.delete(appUser);
    }



    @Test
    @DisplayName("user can be updated")

    void appUserCanBeUpdated(){

        AppUser appUser = appUserRepository.findByEmail("adetola@gmail.com").orElse(null);
        assertThat(appUser).isNotNull();
        assertThat(appUser.getFirstName()).isEqualTo("ade");
        assertThat(appUser.getLastName()).isEqualTo("tola");

        appUser.setEmail("ade@gmail.com");
        log.info("user email has been updated");

        appUserRepository.save(appUser);
        assertThat(appUser.getEmail()).isEqualTo("ade@gmail.com");
        assertThat(appUser.getFirstName()).isEqualTo("ade");

    }

}
package com.example.auctionManagementSystem.datas.repositories;

import com.example.auctionManagementSystem.datas.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}

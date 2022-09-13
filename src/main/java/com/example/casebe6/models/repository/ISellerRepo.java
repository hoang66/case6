package com.example.casebe6.models.repository;

import com.example.casebe6.models.AppUser;
import com.example.casebe6.models.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISellerRepo extends JpaRepository<Seller, Long> {

    Page<Seller> findAll(Pageable pageable);
    @Query(nativeQuery = true, value = "select * from seller where is_accept = false;")
    List<Seller> getWaitingAcceptSeller();

    @Query(nativeQuery = true, value = "SELECT * FROM seller where name like concat('%',:name,'%');")
    Iterable<Seller> findAllByNameContaining(String name);

    Page<Seller> findSellerByIsAccept(Boolean isAccept, Pageable pageable);

    @Query(nativeQuery = true, value = "select * from seller where is_accept = true;")
    Page<Seller>showSeller(Pageable pageable);

    Seller findSellerByAppUser(AppUser appUser);
}

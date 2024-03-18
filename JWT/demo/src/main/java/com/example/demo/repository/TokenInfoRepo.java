package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.entity.TokenInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TokenInfoRepo extends JpaRepository<TokenInfo, Long> {

	Optional<TokenInfo> findByRefreshToken (String refreshToken);

}
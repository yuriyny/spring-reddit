package com.springreddit.springreddit.repository;

import com.springreddit.springreddit.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepositiory extends JpaRepository<RefreshToken, Long> {
}

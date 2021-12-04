package com.developia.goodreads.dao.repository;

import com.developia.goodreads.dao.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    // metodun adiyla novbeti query generasiya olunur
    // select * from users where login = ?
    Optional<UsersEntity> findByLogin(String login);
}

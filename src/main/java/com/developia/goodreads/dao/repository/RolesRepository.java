package com.developia.goodreads.dao.repository;

import com.developia.goodreads.dao.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RolesEntity, Long> {
    RolesEntity findByRole(String role);
}

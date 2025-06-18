package com.example.beer.repository;

import com.example.beer.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // ロール名で検索（例：ROLE_ADMIN, ROLE_USER）
    Optional<Role> findByName(String name);
}

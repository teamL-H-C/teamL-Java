package com.example.beer.repository;

import com.example.beer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // メールアドレスでユーザーを検索（ログイン時に使用）
    Optional<User> findByEmail(String email);

    // 有効なユーザーを絞り込む（オプション）
    Optional<User> findByEmailAndEnabledTrue(String email);
}


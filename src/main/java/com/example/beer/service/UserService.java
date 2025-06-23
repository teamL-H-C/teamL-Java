package com.example.beer.service;

import com.example.beer.model.User;
import com.example.beer.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 全ユーザー取得
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // ID指定でユーザー取得
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    // ユーザー保存
    public void save(User user) {
        userRepository.save(user);
    }

    // ユーザー登録処理（パスワードをハッシュ化）
    public void register(String username, String email, String plainPassword) {
        String hash = passwordEncoder.encode(plainPassword);
        User user = new User(username, email, hash, true);  // ← このコンストラクタが User に必要です
        userRepository.save(user);
    }
}

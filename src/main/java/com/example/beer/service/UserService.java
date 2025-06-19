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

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void register(String username, String email, String plainPassword) {
        String hash = passwordEncoder.encode(plainPassword); // ✔️ ここでハッシュ化
        User user = new User(username, email, hash, true);
        userRepository.save(user);
    }
}

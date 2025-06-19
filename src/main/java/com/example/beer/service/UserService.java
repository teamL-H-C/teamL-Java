package com.example.beer.service;

import com.example.beer.model.User;
import com.example.beer.repository.UserRepository;
import com.example.beer.util.PasswordUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean login(String username, String password) {
        User user = repository.findByUsername(username);
        if (user == null)
            return false;

        String hashed = PasswordUtil.hash(password);
        return hashed.equals(user.getPasswordHash());
    }

    public void register(String username, String password) {
        String hashed = PasswordUtil.hash(password);
        User user = new User(username, hashed);
        repository.save(user);
    }

    public boolean userExists(String username) {
        return repository.findByUsername(username) != null;
    }

}

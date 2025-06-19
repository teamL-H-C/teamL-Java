package com.example.beer.service;

import com.example.beer.model.User;
import com.example.beer.repository.UserRepository;
import com.example.beer.util.PasswordUtil;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * ユーザー認証処理
     * @param username 入力されたユーザー名
     * @param password 入力された平文パスワード
     * @return 認証に成功した場合は true、失敗した場合は false
     */
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) return false;

        String hashedInput = PasswordUtil.hash(password);
        return hashedInput.equals(user.getPasswordHash());
    }

    /**
     * 認証に成功したユーザー情報を返す（オプション）
     */
    public User getUserIfAuthenticated(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) return null;

        String hashedInput = PasswordUtil.hash(password);
        if (hashedInput.equals(user.getPasswordHash())) {
            return user;
        } else {
            return null;
        }
    }
}

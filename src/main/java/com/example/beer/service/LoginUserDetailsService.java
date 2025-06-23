package com.example.beer.service;

import com.example.beer.model.User;
import com.example.beer.repository.UserRepository;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public LoginUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // 有効なユーザーを取得
        User user = userRepository.findByEmailAndEnabledTrue(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        // UserDetails を生成（ロールは仮で "ROLE_USER" を付与）
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPasswordHash(),
                user.getEnabled(),       // enabled
                true,                    // accountNonExpired
                true,                    // credentialsNonExpired
                true,                    // accountNonLocked
                List.of(new SimpleGrantedAuthority("ROLE_USER")) // ← これが必要
        );
    }
}

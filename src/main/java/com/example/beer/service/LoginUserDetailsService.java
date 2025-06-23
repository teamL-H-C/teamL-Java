package com.example.beer.service;

import com.example.beer.model.User;
import com.example.beer.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public LoginUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // 有効なユーザーを取得（メールアドレス + enabled = true）
        User user = userRepository.findByEmailAndEnabledTrue(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        // ユーザーのロールを Spring Security 用の Authority に変換
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))  // 例: "ROLE_ADMIN", "ROLE_STAFF"
                .collect(Collectors.toList());

        // Spring Security の UserDetails を生成して返却
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPasswordHash(),
                user.getEnabled(),
                true,   // accountNonExpired
                true,   // credentialsNonExpired
                true,   // accountNonLocked
                authorities
        );
    }
}

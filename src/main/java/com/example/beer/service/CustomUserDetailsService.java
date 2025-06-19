package com.example.beer.service;

import com.example.beer.model.User;
import com.example.beer.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository repo) {
        this.userRepository = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmailAndEnabledTrue(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        return new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPasswordHash(),
            user.isEnabled(), // enabled
            true, // accountNonExpired
            true, // credentialsNonExpired
            true, // accountNonLocked
            java.util.List.of(new SimpleGrantedAuthority("ROLE_USER")) // 権限（必要ならRole拡張可）
        );
    }
}

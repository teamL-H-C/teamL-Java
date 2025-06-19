package com.example.beer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/", "/login", "/register", "/error").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")                             // 自作の login.html を使用
                .loginProcessingUrl("/login")                    // POSTの送信先URL（フォームのaction）
                .defaultSuccessUrl("/dashboard", true)           // ログイン成功後
                .failureUrl("/login?error=true")                 // ログイン失敗後
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")          // ログアウト成功時
                .permitAll()
            )
            .csrf(csrf -> csrf.disable()); // CSRFは開発中はオフでもOK（本番では有効化して）

        return http.build();
    }
}

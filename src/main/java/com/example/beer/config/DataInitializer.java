package com.example.beer.config;

import com.example.beer.model.Role;
import com.example.beer.model.User;
import com.example.beer.repository.RoleRepository;
import com.example.beer.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner setupUsers(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        return args -> {
            // 管理者ロールの作成または取得
            Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseGet(() -> roleRepository.save(new Role("ROLE_ADMIN")));

            // スタッフロールの作成または取得
            Role staffRole = roleRepository.findByName("ROLE_STAFF")
                .orElseGet(() -> roleRepository.save(new Role("ROLE_STAFF")));

            // 管理者ユーザー作成
            if (userRepository.findByEmailAndEnabledTrue("admin@example.com").isEmpty()) {
                User admin = new User();
                admin.setUsername("管理者ユーザー");
                admin.setEmail("admin@example.com");
                admin.setPasswordHash(encoder.encode("admin123"));
                admin.setEnabled(true);
                admin.setRoles(Set.of(adminRole));
                userRepository.save(admin);
                System.out.println("✅ 管理者登録完了: admin@example.com / admin123");
            }

            // スタッフユーザー作成
            if (userRepository.findByEmailAndEnabledTrue("staff@example.com").isEmpty()) {
                User staff = new User();
                staff.setUsername("スタッフユーザー");
                staff.setEmail("staff@example.com");
                staff.setPasswordHash(encoder.encode("staff123"));
                staff.setEnabled(true);
                staff.setRoles(Set.of(staffRole));
                userRepository.save(staff);
                System.out.println("✅ スタッフ登録完了: staff@example.com / staff123");
            }
        };
    }
}

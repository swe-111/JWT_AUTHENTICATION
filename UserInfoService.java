package com.example.authentications.service;

import com.example.authentications.entity.UserInfo;
import com.example.authentications.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserInfoService  implements UserDetailsService {
    private final UserInfoRepository repository;
    private final PasswordEncoder encoder;

    public UserInfoService(UserInfoRepository repository,
                           PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Optional<UserInfo> userInfo = repository.findByEmail(username);

        if (userInfo.isEmpty()) {
            throw new UsernameNotFoundException(
                    "User not found with email: " + username
            );
        }

        return new UserInfoDetails(userInfo.get());
    }

    public String addUser(UserInfo userInfo) {

        userInfo.setPassword(
                encoder.encode(userInfo.getPassword())
        );

        repository.save(userInfo);

        return "User added successfully";
    }
}

package org.example.examplemongo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.examplemongo.config.JwtTokenUtil;
import org.example.examplemongo.domain.entity.User;
import org.example.examplemongo.dto.request.LoginRequest;
import org.example.examplemongo.dto.request.UserResquest;
import org.example.examplemongo.dto.response.UserResponse;
import org.example.examplemongo.mapper.UserMapper;
import org.example.examplemongo.repository.UserRepository;
import org.example.examplemongo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    @Override
    public UserResponse register(UserResquest userResquest) {

        User user=userMapper.toEntity(userResquest);

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);


        User savedUser = userRepository.save(user);



        return userMapper.toResponse(savedUser);
    }

    @Override
    public UserResponse login(LoginRequest loginRequest) {
        return null;
    }
}

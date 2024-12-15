package org.example.examplemongo.service;

import org.example.examplemongo.dto.request.LoginRequest;
import org.example.examplemongo.dto.request.UserResquest;
import org.example.examplemongo.dto.response.UserResponse;

public interface UserService {
    UserResponse register(UserResquest userResquest);
    UserResponse login(LoginRequest loginRequest);
}

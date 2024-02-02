package com.explore.larosa.v1.Services;

import com.explore.larosa.v1.Model.User;

public interface UserService {
    
    User registerUser(User user);

    User loginUser(String username, String password);
}

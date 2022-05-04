package com.exam.service;

import com.exam.entity.User;
import com.exam.entity.UserRole;

import java.util.Set;

public interface UserService {

//    creating user
    public User creatUser(User user, Set<UserRole> userRoles) throws Exception;
}

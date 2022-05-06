package com.exam.service;

import com.exam.entity.User;
import com.exam.entity.UserRole;

import java.util.Set;

public interface UserService {

//    creating user
    public User creatUser(User user, Set<UserRole> userRoles) throws Exception;

//    getuser details by username
    public User getUser(String username);

//    delete user by id
    public void deleteUser(Long userId);

//    update user details
    public User updateUser(User user) throws Exception;
}

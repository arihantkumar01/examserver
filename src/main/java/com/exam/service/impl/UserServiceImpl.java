package com.exam.service.impl;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

//    creating user
    @Override
    public User creatUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());
        if(local!=null)
        {
            System.out.println("user is already there !!!");
            throw new Exception(("User already present"));
        }
        else
        {
//            user create
            for(UserRole ur:userRoles)
            {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

//    get user details by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());

        if(user.getEmail() != null)
            local.setEmail(user.getEmail());
        if(user.getFirstName() != null)
            local.setFirstName(user.getFirstName());
        if(user.getLastName() != null)
            local.setLastName(user.getLastName());
        if(user.getMobile() != null)
            local.setMobile(user.getMobile());
        if(user.getPassword() != null)
            local.setPassword(user.getPassword());

        userRepository.save(local);

        return userRepository.findByUsername(local.getUsername());
    }
}

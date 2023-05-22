package com.google.jwt.service;

import com.google.jwt.dao.RoleDao;
import com.google.jwt.dao.UserDao;
import com.google.jwt.entity.Role;
import com.google.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    public User registerNewUser(User user) {
        return userDao.save(user);
    }

    public void initRolesAndUser() {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword("admin@pass");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserFirstName("dame");
        user.setUserLastName("dame");
        user.setUserName("dame123");
        user.setUserPassword("dame@pass");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(adminRole);
        user.setRole(userRoles);
        userDao.save(user);
    }








}

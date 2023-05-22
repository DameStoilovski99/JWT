package com.google.jwt.service;

import com.google.jwt.dao.RoleDao;
import com.google.jwt.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    public Role createNewRole(Role role) {
        // Save the role and return the message
        return roleDao.save(role);
    }
}

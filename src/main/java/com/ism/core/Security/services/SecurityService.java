package com.ism.core.Security.services;

import core.ism.dependance.Data.Entity.AppRole;
import core.ism.dependance.Data.Entity.AppUser;

public interface SecurityService {

    AppUser getUserByUsername(String username);
    AppUser saveUser(String username,String password);

    AppRole saveRole(String roleName);

    void addRoleToUser(String username,String roleName);
}

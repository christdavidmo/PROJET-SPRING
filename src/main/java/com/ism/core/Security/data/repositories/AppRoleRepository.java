package com.ism.core.Security.data.repositories;

import core.ism.dependance.Data.Entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {

    AppRole getByRolename(String username);

    boolean existsByRolename(String roleName);
}

package com.ism.core.Security.data.repositories;

import core.ism.dependance.Data.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    AppUser findByLogin(String username);

    boolean existsByLogin(String username);
}

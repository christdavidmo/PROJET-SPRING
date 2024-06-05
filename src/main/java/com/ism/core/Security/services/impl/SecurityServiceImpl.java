package com.ism.core.Security.services.impl;



import com.ism.core.Security.data.repositories.AppRoleRepository;
import com.ism.core.Security.data.repositories.AppUserRepository;
import com.ism.core.Security.services.SecurityService;
import core.ism.dependance.Data.Entity.AppRole;
import core.ism.dependance.Data.Entity.AppUser;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService, UserDetailsService {

    private final AppRoleRepository appRoleRepository;
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public AppUser getUserByUsername(String username) {

        return appUserRepository.findByLogin(username);
    }

    @Override
    public AppUser saveUser(String username, String password) {
        if (appUserRepository.existsByLogin(username)) {
            throw new UsernameAlreadyExistsException("Un utilisateur avec ce nom d'utilisateur existe déjà.");
        }
        AppUser user = new AppUser(username, passwordEncoder.encode(password));
        return appUserRepository.save(user);
    }

    @Override
    public AppRole saveRole(String roleName) {
        if (appRoleRepository.existsByRolename(roleName)) {
            throw new RoleAlreadyExistsException("Ce rôle existe déjà.");
        }
        AppRole role = new AppRole(roleName);
        return appRoleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = appUserRepository.findByLogin(username);
        AppRole role = appRoleRepository.getByRolename(roleName);

        if (user == null) {
            throw new UserNotFoundException("L'utilisateur '" + username + "' n'existe pas.");
        }
        if (role == null) {
            throw new RoleNotFoundException("Le rôle '" + roleName + "' n'existe pas.");
        }

        user.getRoles().add(role);
        appUserRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByLogin(username);

        //System.out.println(appUser.toString());

        // Vérifier si l'utilisateur existe
        if (appUser == null) {
            throw new UsernameNotFoundException("L'utilisateur '" + username + "' n'a pas été trouvé.");
        }

        // Si l'utilisateur est trouvé, créer les autorisations
        List<SimpleGrantedAuthority> authorities = appUser.getRoles().stream()
                .map(appRole -> new SimpleGrantedAuthority(appRole.getRolename())).toList();

        // Retourner un objet User
        return new User(appUser.getLogin(),appUser.getPassword(),authorities);
    }












    // Exceptions personnalisées pour une meilleure gestion des erreurs
    public static class UsernameAlreadyExistsException extends RuntimeException {
        public UsernameAlreadyExistsException(String message) {
            super(message);
        }
    }

    public static class RoleAlreadyExistsException extends RuntimeException {
        public RoleAlreadyExistsException(String message) {
            super(message);
        }
    }

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    public static class RoleNotFoundException extends RuntimeException {
        public RoleNotFoundException(String message) {
            super(message);
        }
    }
}


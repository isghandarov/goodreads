package com.developia.goodreads.service;

import com.developia.goodreads.dao.entity.RolesEntity;
import com.developia.goodreads.dao.entity.UsersEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private UserService userService;

    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity user = userService.getUserByLogin(username);
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (RolesEntity role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        User springUser = new User(
                user.getLogin(), user.getPassword(), user.getActive(), true,
                true, true, authorities
        );
        return springUser;
    }
}

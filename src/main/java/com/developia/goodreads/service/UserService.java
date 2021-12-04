package com.developia.goodreads.service;

import com.developia.goodreads.dao.entity.RolesEntity;
import com.developia.goodreads.dao.entity.UsersEntity;
import com.developia.goodreads.dao.repository.RolesRepository;
import com.developia.goodreads.dao.repository.UsersRepository;
import com.developia.goodreads.model.exception.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UsersRepository usersRepository;
    private BCryptPasswordEncoder encoder;
    private RolesRepository rolesRepository;

    public UserService(UsersRepository usersRepository,
                       BCryptPasswordEncoder encoder,
                       RolesRepository rolesRepository) {
        this.usersRepository = usersRepository;
        this.encoder = encoder;
        this.rolesRepository = rolesRepository;
    }

    public UsersEntity getUserByLogin(String login) {
        UsersEntity user = usersRepository.findByLogin(login).
                orElseThrow(
                        () -> {
                            throw new NotFoundException("User not found");
                        }
                );

        return user;
    }

    public void register(UsersEntity user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setActive(true);

        List<RolesEntity> roles = new ArrayList<>();
        RolesEntity role = rolesRepository.findByRole("USER");
        roles.add(role);

        user.setRoles(roles);
        usersRepository.save(user);
    }
}

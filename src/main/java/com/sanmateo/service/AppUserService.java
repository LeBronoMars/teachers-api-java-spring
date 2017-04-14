package com.sanmateo.service;

import com.sanmateo.dao.AppUserRepository;
import com.sanmateo.exceptions.NotFoundException;
import com.sanmateo.exceptions.UsernameOrEmailAlreadyExistException;
import com.sanmateo.model.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by rsbulanon on 4/14/17.
 */
@Service
@Transactional
public class AppUserService {
    private final Logger log = LoggerFactory.getLogger(AppUserService.class);

    @Inject
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser createUser(final AppUser user) {
        final Optional<AppUser> existingUserByUsername = appUserRepository.findByUsername(user.getUsername());

        if (existingUserByUsername.isPresent()) {
            throw new UsernameOrEmailAlreadyExistException(user.getUsername());
        } else {
            final Optional<AppUser> existingUserByEmail = appUserRepository.findByEmail(user.getEmail());

            if (existingUserByEmail.isPresent()) {
                throw new UsernameOrEmailAlreadyExistException(user.getEmail());
            } else {
                user.setId(null);
                log.info("\n\n\n password: {} \n\n\n", user.getPassword());
                user.setPassword(passwordEncoder.encode(user.getPassword()));

                /** set default status to 'Active' */
                user.setStatus("Active");

                /** generate default Avatar */
                final String encodedUsername = passwordEncoder.encode(user.getEmail());
                user.setPicUrl("http://www.gravatar.com/avatar/" + encodedUsername + "?d=identicon");

                appUserRepository.save(user);
                log.info("New user successfully created: {}", user);
                return user;
            }
        }
    }

    public Page<AppUser> findAll(Pageable pageable) {
        return appUserRepository.findAll(pageable);
    }

    public AppUser findOne(final String id) {
        return appUserRepository.findOne(id);
    }

    public AppUser findByUsername(String username) {
        Optional<AppUser> appUser = appUserRepository.findByUsername(username);
        return appUser.map(user -> user).orElseThrow(() -> new NotFoundException(AppUser.class, username));
    }

}

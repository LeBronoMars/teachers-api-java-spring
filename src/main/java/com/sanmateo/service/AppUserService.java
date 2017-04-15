package com.sanmateo.service;

import com.sanmateo.dao.AppUserRepository;
import com.sanmateo.dto.user.AppUserRegistrationDto;
import com.sanmateo.exceptions.NotFoundException;
import com.sanmateo.exceptions.CustomException;
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

    public AppUser createUser(final AppUserRegistrationDto appUserRegistrationDto) {
        final Optional<AppUser> existingUserByUsername = appUserRepository.findByUsername(appUserRegistrationDto.getUsername());

        if (existingUserByUsername.isPresent()) {
            throw new CustomException("Username: '" + appUserRegistrationDto.getUsername() + "' already in use.");
        } else {
            final Optional<AppUser> existingUserByEmail = appUserRepository.findByEmail(appUserRegistrationDto.getEmail());

            if (existingUserByEmail.isPresent()) {
                throw new CustomException("Email: '" + appUserRegistrationDto.getEmail() + "' already in use.");
            } else {
                final Optional<AppUser> existingUserByEmployeeNo = appUserRepository.findByEmployeeNo(appUserRegistrationDto.getEmployeeNo());

                if (existingUserByEmployeeNo.isPresent()) {
                    throw new CustomException("Employee No:' " + appUserRegistrationDto.getEmployeeNo() + "' already in use.");
                } else {
                    final AppUser newUser = new AppUser();
                    newUser.setId(null);
                    newUser.setEmployeeNo(appUserRegistrationDto.getEmployeeNo());
                    newUser.setFirstName(appUserRegistrationDto.getFirstName());
                    newUser.setMiddleName(appUserRegistrationDto.getMiddleName());
                    newUser.setLastName(appUserRegistrationDto.getLastName());
                    newUser.setAddress(appUserRegistrationDto.getAddress());
                    newUser.setContactNo(appUserRegistrationDto.getContactNo());
                    newUser.setBirthDate(appUserRegistrationDto.getBirthDate());
                    newUser.setEmail(appUserRegistrationDto.getEmail());
                    newUser.setUsername(appUserRegistrationDto.getUsername());
                    newUser.setRole(appUserRegistrationDto.getRole());
                    newUser.setPosition(appUserRegistrationDto.getPosition());
                    newUser.setGender(appUserRegistrationDto.getGender());
                    newUser.setCivilStatus(appUserRegistrationDto.getCivilStatus());
                    newUser.setPassword(passwordEncoder.encode(appUserRegistrationDto.getPassword()));

                    /** set default status to 'Active' */
                    newUser.setStatus("Active");

                    /** generate default Avatar */
                    final String encodedUsername = passwordEncoder.encode(appUserRegistrationDto.getEmail());
                    newUser.setPicUrl("http://www.gravatar.com/avatar/" + encodedUsername + "?d=identicon");

                    appUserRepository.save(newUser);
                    log.info("New user successfully created: {}", newUser);
                    return newUser;
                }
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

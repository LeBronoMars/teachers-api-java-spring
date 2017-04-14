package com.sanmateo.controller;

import com.sanmateo.config.JwtConfigurer;
import com.sanmateo.config.TokenProvider;
import com.sanmateo.dto.AppUserDto;
import com.sanmateo.dto.AppUserLoginDto;
import com.sanmateo.model.AppUser;
import com.sanmateo.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Optional;

/**
 * Created by rsbulanon on 4/14/17.
 */
@Controller
@RequestMapping(path = "/api")
public class AppUserController {

    private final Logger log = LoggerFactory.getLogger(AppUserController.class);

    @Inject
    private AuthenticationManager authenticationManager;

    @Autowired
    private AppUserService appUserService;

    @Inject
    private TokenProvider tokenProvider;

    @Value("${jwt.app.secret}")
    private String jwtSecret;

    @Value("${jwt.app.expiryInMillis}")
    private Long jwtExpiryInMillis = (60 * 60 * 24 * 1000L);

    /**
     * create new user
     */
    @RequestMapping(value = "/users/register",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@Valid @RequestBody AppUser user) throws URISyntaxException {
        log.info("REST request to save User : {}", user);
        final AppUser newUser = appUserService.createUser(user);
        return ResponseEntity.created(new URI("/api/users/" + newUser.getId())).body(newUser);
    }

    @RequestMapping(value = "/user/auth", method = RequestMethod.POST)
    public ResponseEntity<?> authorize(@Valid @RequestBody AppUserLoginDto appUserLoginDto, HttpServletResponse response) {

        log.info("REST request to authenticate user : {}", appUserLoginDto);
        final UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(appUserLoginDto.getUsername(),
                        appUserLoginDto.getPassword());

        log.info("UsernamePassword Auth Token : {}", authenticationToken);
        try {
            final Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.createToken(authentication);
            response.addHeader(JwtConfigurer.AUTHORIZATION_HEADER, "Bearer " + jwt);
            return ResponseEntity.ok(new LoginResponse(jwt));
        } catch (AuthenticationException exception) {
            return new ResponseEntity<>(Collections.singletonMap("authentication_exception", exception.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    private static class LoginResponse {
        public String token;

        public LoginResponse(final String token) {
            this.token = token;
        }
    }

    /**
     * get user by id
     */
    @RequestMapping(value = "/users/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppUserDto> getUserById(@PathVariable String id) {
        log.info("REST request to get User : {}", id);
        AppUser user = appUserService.findOne(id);
        return Optional.ofNullable(user)
                .map(result -> new ResponseEntity<>(
                        convert(result),
                        HttpStatus.OK))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * get all users
     */
    @RequestMapping(value = "/users",
            path = "/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(readOnly = true)
    public ResponseEntity<Page<AppUser>> getAllUsers(Pageable pageable) throws URISyntaxException {
        final Page<AppUser> users = appUserService.findAll(pageable);
        log.info("REST request to get all users : {}", users);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    public AppUserDto convert(final AppUser appUser) {
        final AppUserDto userDto = new AppUserDto();
        userDto.setId(appUser.getId());
        userDto.setEmployeeNo(appUser.getEmployeeNo());
        userDto.setFirstName(appUser.getFirstName());
        userDto.setMiddleName(appUser.getMiddleName());
        userDto.setLastName(appUser.getLastName());
        userDto.setAddress(appUser.getAddress());
        userDto.setContactNo(appUser.getContactNo());
        userDto.setBirthDate(appUser.getBirthDate());
        userDto.setEmail(appUser.getEmail());
        userDto.setUsername(appUser.getUsername());
        userDto.setRole(appUser.getRole());
        userDto.setStatus(appUser.getStatus());
        userDto.setPicUrl(appUser.getPicUrl());
        userDto.setPosition(appUser.getPosition());
        userDto.setGender(appUser.getGender());
        userDto.setCivilStatus(appUser.getCivilStatus());
        userDto.setSynced(appUser.isSynced());
        return userDto;
    }
}

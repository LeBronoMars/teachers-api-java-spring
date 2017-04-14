package com.sanmateo.dao;

import com.sanmateo.model.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by rsbulanon on 4/14/17.
 */
public interface AppUserRepository extends CrudRepository<AppUser, String> {

    Page<AppUser> findAll(Pageable pageable);

    Optional<AppUser> findByUsername(String username);

    Optional<AppUser> findByEmail(String email);

    Optional<AppUser> findByEmployeeNo(final String employeeNo);
}

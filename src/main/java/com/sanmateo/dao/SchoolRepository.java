package com.sanmateo.dao;

import com.sanmateo.model.AppUser;
import com.sanmateo.model.School;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by rsbulanon on 4/14/17.
 */
public interface SchoolRepository extends CrudRepository<School, String> {

    Page<School> findAll(Pageable pageable);

    Optional<School> findBySchoolName(String schoolName);
}

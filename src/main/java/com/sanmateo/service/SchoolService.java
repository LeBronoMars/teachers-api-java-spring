package com.sanmateo.service;

import com.sanmateo.dao.SchoolRepository;
import com.sanmateo.exceptions.CustomException;
import com.sanmateo.model.AppUser;
import com.sanmateo.model.School;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by rsbulanon on 4/14/17.
 */
@Service
@Transactional
public class SchoolService {
    private final Logger log = LoggerFactory.getLogger(SchoolService.class);

    @Autowired
    private SchoolRepository schoolRepository;

    public School createSchool(final School newSchool) {
        final Optional<School> existingSchool = schoolRepository.findBySchoolName(newSchool.getSchoolName());

        if (existingSchool.isPresent()) {
            throw new CustomException("School name: '"+ newSchool.getSchoolName() +"' already in use.");
        } else {
            return schoolRepository.save(newSchool);
        }
    }

    public Page<School> findAll(Pageable pageable) {
        return schoolRepository.findAll(pageable);
    }

    public School findOne(final String id) {
        return schoolRepository.findOne(id);
    }
}

package com.sanmateo.service;

import com.sanmateo.dao.AppUserRepository;
import com.sanmateo.dao.SchoolRepository;
import com.sanmateo.dto.school.SchoolDto;
import com.sanmateo.dto.school.SchoolRegistrationDto;
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

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUserService appUserService;

    public School createSchool(final SchoolRegistrationDto registrationDto) {
        final Optional<School> existingSchool = schoolRepository.findBySchoolName(registrationDto.getSchoolName());

        if (existingSchool.isPresent()) {
            throw new CustomException("School name: '"+ registrationDto.getSchoolName() +"' already in use.");
        } else {
            final AppUser user = appUserRepository.findOne(registrationDto.getPrincipal());

            return Optional.ofNullable(user).map(principal -> {
                if (principal.getPosition().toString().equalsIgnoreCase("PRINCIPAL")) {
                    log.info("Principal {}", principal);
                    final Optional<School> isPrincipalAvailable = schoolRepository.findByPrincipal(principal);

                    if (isPrincipalAvailable.isPresent()) {
                        throw new CustomException("Principal " + principal.getFirstName() + " " + principal.getLastName()
                                + " was already assigned to " + existingSchool.get().getSchoolName());
                    } else {
                        final School newSchool = new School();
                        newSchool.setId(null);
                        newSchool.setSchoolName(registrationDto.getSchoolName());
                        newSchool.setSchoolAddress(registrationDto.getSchoolAddress());
                        newSchool.setContactNo(registrationDto.getContactNo());
                        newSchool.setEmail(registrationDto.getEmail());
                        newSchool.setPrincipal(principal);
                        return schoolRepository.save(newSchool);
                    }
                } else {
                    throw new CustomException("Only users with Principal role are allowed to be assigned as school principal.");
                }
            }).orElseThrow(() -> new com.sanmateo.exceptions.NotFoundException(AppUser.class, registrationDto.getPrincipal()));
        }
    }

    public Page<School> findAll(Pageable pageable) {
        return schoolRepository.findAll(pageable);
    }

    public School findOne(final String id) {
        return schoolRepository.findOne(id);
    }

    public SchoolDto convert(School school) {
        final SchoolDto schoolDto = new SchoolDto();
        schoolDto.setId(school.getId());
        schoolDto.setSchoolName(school.getSchoolName());
        schoolDto.setSchoolAddress(school.getSchoolAddress());
        schoolDto.setContactNo(school.getContactNo());
        schoolDto.setEmail(school.getEmail());
        schoolDto.setPrincipal(appUserService.convert(school.getPrincipal()));
        return schoolDto;
    }
}

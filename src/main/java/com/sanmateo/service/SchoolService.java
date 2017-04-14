package com.sanmateo.service;

import com.sanmateo.dao.SchoolRepository;
import com.sanmateo.model.School;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rsbulanon on 4/14/17.
 */
@Service
@Transactional
public class SchoolService {
    private final Logger log = LoggerFactory.getLogger(SchoolService.class);

    @Autowired
    private SchoolRepository schoolRepository;

    public void createSchool(final School school) {
        
    }

}

package com.sanmateo.controller;

import com.sanmateo.dto.school.SchoolRegistrationDto;
import com.sanmateo.exceptions.CustomException;
import com.sanmateo.exceptions.NotFoundException;
import com.sanmateo.model.School;
import com.sanmateo.service.SchoolService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class SchoolController {

    private final Logger log = LoggerFactory.getLogger(SchoolController.class);

    @Autowired
    private SchoolService schoolService;

    /**
     * create new school record
     */
    @RequestMapping(value = "/school",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Bearer {{token}}",
                    required = true, dataType = "string", paramType = "header")
    })
    public ResponseEntity<?> createSchool(@Valid @RequestBody SchoolRegistrationDto schoolRegistrationDto) throws URISyntaxException {
        log.info("REST request to create new school : {}", schoolRegistrationDto);
        try {
            final School newSchool = schoolService.createSchool(schoolRegistrationDto);
            return ResponseEntity.created(new URI("/api/schools/" + newSchool.getId())).body(newSchool);
        } catch (CustomException e) {
            return new ResponseEntity<>(Collections.singletonMap("message", e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(Collections.singletonMap("message", e.getLocalizedMessage()), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * get school record by id
     */
    @RequestMapping(value = "/schools/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Bearer {{token}}",
                    required = true, dataType = "string", paramType = "header")
    })
    public ResponseEntity<School> getSchoolById(@PathVariable String id) {
        log.info("REST request to get School by Id : {}", id);
        final School school = schoolService.findOne(id);
        return Optional.ofNullable(school)
                .map(result -> new ResponseEntity<>(
                        school,
                        HttpStatus.OK))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}

package com.sanmateo.dao;

import com.sanmateo.model.School;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rsbulanon on 4/14/17.
 */
public interface SchoolRepository extends CrudRepository<School, String> {
}

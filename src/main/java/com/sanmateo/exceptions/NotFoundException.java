package com.sanmateo.exceptions;

import com.sanmateo.model.BaseModel;

/**
 * Created by rsbulanon on 4/14/17.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(Class<? extends BaseModel> clazz, String id) {
        super("Resource " + clazz.getSimpleName() + " ID not found: " + id);
    }
}

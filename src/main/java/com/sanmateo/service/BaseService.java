package com.sanmateo.service;


import com.sanmateo.model.BaseModel;

/**
 * Created by ginduc on 20/07/16.
 */
abstract public class BaseService {
    class NotFoundException extends RuntimeException {
        public NotFoundException(Class<? extends BaseModel> clazz, String id) {
            super("Resource " + clazz.getSimpleName() + " ID not found: " + id);
        }
    }

}

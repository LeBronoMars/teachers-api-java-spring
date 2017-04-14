package com.sanmateo.service;


import com.sanmateo.model.BaseModel;

/**
 * Created by rsbulanon on 4/14/17.
 */
abstract public class BaseService {
    class NotFoundException extends RuntimeException {
        public NotFoundException(Class<? extends BaseModel> clazz, String id) {
            super("Resource " + clazz.getSimpleName() + " ID not found: " + id);
        }
    }

    class UsernameOrEmailAlreadyExistException extends RuntimeException {
        public UsernameOrEmailAlreadyExistException(String usernameOrEmail) {
            super(usernameOrEmail + " already in used.");
        }
    }
}

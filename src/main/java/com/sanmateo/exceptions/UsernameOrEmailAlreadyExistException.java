package com.sanmateo.exceptions;

/**
 * Created by rsbulanon on 4/14/17.
 */
public class UsernameOrEmailAlreadyExistException extends RuntimeException {

    public UsernameOrEmailAlreadyExistException(String usernameOrEmail) {
        super(usernameOrEmail + " already in used.");
    }
}

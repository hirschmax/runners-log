package com.github.hirschmax.exceptions;

import java.io.Serializable;

public class PersonNotFoundException extends RuntimeException implements Serializable {

    public PersonNotFoundException(String msg) {
        super(msg);
    }

}

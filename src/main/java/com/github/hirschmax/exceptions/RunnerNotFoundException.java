package com.github.hirschmax.exceptions;

import java.io.Serializable;

public class RunnerNotFoundException extends RuntimeException implements Serializable {

    public RunnerNotFoundException(String msg) {
        super(msg);
    }

}

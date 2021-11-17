package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundById extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CustomerNotFoundById(String message) {
        super(message);
    }

    public CustomerNotFoundById(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerNotFoundById(Throwable cause) {
        super(cause);
    }

    public CustomerNotFoundById() {
    }
<<<<<<< HEAD

=======
>>>>>>> cc5377a462eeac9a8c89d8db2b6f8c18a11263ec
}

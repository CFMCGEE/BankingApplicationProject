package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class CustomerSuccessfullyFoundException extends RuntimeException {
    public static final Long serialVersionUID = 1L;

    public CustomerSuccessfullyFoundException(String message) {
        super(message);
    }

    public CustomerSuccessfullyFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerSuccessfullyFoundException(Throwable cause) {
        super(cause);
    }

    public CustomerSuccessfullyFoundException() {
    }
<<<<<<< HEAD

=======
>>>>>>> cc5377a462eeac9a8c89d8db2b6f8c18a11263ec
}

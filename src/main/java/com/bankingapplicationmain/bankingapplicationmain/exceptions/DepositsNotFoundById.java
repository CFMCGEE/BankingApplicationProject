package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepositsNotFoundById extends RuntimeException {
  
    private static final long serialVersionUID = 1L;

   public DepositsNotFoundById(){

   }

  public DepositsNotFoundById(String message){
      super(message);
  }

  public DepositsNotFoundById(String message, Throwable cause){
      super(message, cause);
  }
  public DepositsNotFoundById(Throwable cause){
      super(cause);
  }


}

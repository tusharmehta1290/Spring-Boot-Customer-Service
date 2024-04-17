package com.niit.Practice1CustomerServiceApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT , reason = "Customer with specified id is not found")
public class CustomerNotFoundException extends Exception {
}

package com.saad.monolithicproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    CUSTOMER_NOT_FOUND(1003,"The customer you are looking for could not be found.", INTERNAL_SERVER_ERROR),
    CUSTOMER_COULD_NOT_BE_ERASED(1004,"Customer could not be erased", INTERNAL_SERVER_ERROR),
    ADD_SALES_PROBLEM(2005,"It was seen that the required fields were empty while adding Sales.", INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    HttpStatus httpStatus;

}

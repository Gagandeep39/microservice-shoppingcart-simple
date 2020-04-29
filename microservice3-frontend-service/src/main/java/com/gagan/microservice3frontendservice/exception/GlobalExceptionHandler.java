/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-29 19:04:16
 * @modify date 2020-04-29 19:04:16
 * @desc [description]
 */
package com.gagan.microservice3frontendservice.exception;

import com.gagan.microservice3frontendservice.model.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler
    // public ResponseEntity<ErrorResponse> handleAllError(Exception exception){
    //     ErrorResponse response = new ErrorResponse();
    //     response.setStatus(HttpStatus.BAD_REQUEST.value());
    //     response.setTimeStamp(System.currentTimeMillis());
    //     response.setMessage(exception.getMessage());
    //     return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    // }

    @ExceptionHandler
    public String handleAllError(Exception exception, Model model){
        ErrorResponse response = new ErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimeStamp(System.currentTimeMillis());
        response.setMessage(exception.getMessage());
        model.addAttribute("error", response);
        return "/Error";
    }

}
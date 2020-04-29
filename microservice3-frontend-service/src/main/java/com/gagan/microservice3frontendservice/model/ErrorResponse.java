/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-29 19:02:42
 * @modify date 2020-04-29 19:02:42
 * @desc [description]
 */
package com.gagan.microservice3frontendservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

}
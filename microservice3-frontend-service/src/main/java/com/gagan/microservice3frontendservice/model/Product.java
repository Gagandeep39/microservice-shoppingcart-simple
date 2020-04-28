/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-28 18:46:13
 * @modify date 2020-04-28 18:46:13
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
public class Product {

    Integer id;
    Integer stock;
    String name;
    String category;
    Integer price;

}
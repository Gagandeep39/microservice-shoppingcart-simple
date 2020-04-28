/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-28 18:46:13
 * @modify date 2020-04-28 18:46:13
 * @desc [description]
 */
package com.gagan.microservice3productservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    Integer id;
    @Column(name = "stock")
    Integer stock;
    @Column(name = "name")
    String name;
    @Column(name = "cat")
    String category;
    @Column(name = "price")
    Integer price;

}
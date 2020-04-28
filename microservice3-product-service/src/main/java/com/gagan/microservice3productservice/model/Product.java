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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel("Product Info")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    @ApiModelProperty("ID")
    Integer id;

    @Column(name = "stock")
    @ApiModelProperty("Avcailable Stocks")
    Integer stock;

    @Column(name = "name")
    @ApiModelProperty("Product Name")
    String name;

    @Column(name = "cat")
    @ApiModelProperty("Product Category")
    String category;

    @Column(name = "price")
    @ApiModelProperty("Product Price")
    Integer price;

}
/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-28 19:05:59
 * @modify date 2020-04-28 19:05:59
 * @desc [description]
 */
package com.gagan.microservice3frontendservice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cart {

    private Integer cartId;
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Integer id){
        products = products.stream().filter(p->p.getId()!=id).collect(Collectors.toList());
    }

}
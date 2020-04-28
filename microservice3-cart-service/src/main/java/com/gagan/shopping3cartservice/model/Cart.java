/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-28 19:05:59
 * @modify date 2020-04-28 19:05:59
 * @desc [description]
 */
package com.gagan.shopping3cartservice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Cart {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;
    @ManyToMany
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Integer id){
        products = products.stream().filter(p->p.getId()!=id).collect(Collectors.toList());
    }

}
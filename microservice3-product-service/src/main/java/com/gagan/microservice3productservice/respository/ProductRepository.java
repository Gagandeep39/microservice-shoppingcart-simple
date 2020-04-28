/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-28 18:46:16
 * @modify date 2020-04-28 18:46:16
 * @desc [description]
 */
package com.gagan.microservice3productservice.respository;

import java.util.List;

import com.gagan.microservice3productservice.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("Select p from Product p Where p.category=?1")
    public List<Product> findByCategory(String category);

}
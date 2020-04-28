/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-28 19:13:00
 * @modify date 2020-04-28 19:13:00
 * @desc [description]
 */
package com.gagan.shopping3cartservice.repository;

import com.gagan.shopping3cartservice.model.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
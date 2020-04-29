/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-29 14:52:52
 * @modify date 2020-04-29 14:52:52
 * @desc [description]
 */
package com.gagan.shopping3cartservice.service;

import com.gagan.shopping3cartservice.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CircuitBreakerService {

    
    Logger logger = LoggerFactory.getLogger(CircuitBreakerService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Product dummyProduct;

    @HystrixCommand(fallbackMethod = "fallbackUpdateStock")
	public Product updateStock(Product p) {
        logger.info("NORMAL");
		return restTemplate.postForObject("http://localhost:5001/products/" + p.getId()+ "/1", "", Product.class);
    }
    
    public Product fallbackUpdateStock(Product p) {
        logger.info("FALLBACK");
		return dummyProduct;
	}

}
/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-28 23:18:31
 * @modify date 2020-04-28 23:18:31
 * @desc [description]
 */
package com.gagan.shopping3cartservice.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
public class BeanConfiguration {
    @Bean
    public Docket swaggerCongiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // .paths(PathSelectors.ant("/"))	// Will prevent some Paths from being Shown
                // .apis(RequestHandlerSelectors.basePackage("com.gagan"))
                .build()
                .apiInfo(apidetails());
    }

    /**
     * API Info
     * Name
     * Description
     * Version
     * Terms of Services
     * Contacts Info
     * License Info
     * Company URL
     * Addition Vender Info (Collections<VendorInfo> asd)
     */
    private ApiInfo apidetails() {
        return new ApiInfo(
                "Products API",
                "It Contains Information about the products that are managed via API",
                "1.0G",
                "My Terms of Services",
                new Contact("Gagandeep Singh", "github.com/gagandeep39", "singh.gagandeep3911@gmail.com"),
                "API license",
                "www.gagandeep.com",
                Collections.emptyList());
    }

}
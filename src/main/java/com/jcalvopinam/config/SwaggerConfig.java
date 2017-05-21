/*
MIT License

Copyright (c) 2017 JUAN CALVOPINA M

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package com.jcalvopinam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by juanca on 5/18/17.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String PUBLIC_API = "public-api";

    @Autowired
    private Environment env;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).groupName(PUBLIC_API).apiInfo(apiInfo()).select().paths(
                PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(env.getProperty("swagger.api.info.title"))
                                   .description(env.getProperty("swagger.api.info.description"))
                                   .termsOfServiceUrl(env.getProperty("swagger.api.info.description"))
                                   .contact(getContactInfo())
                                   .license(env.getProperty("swagger.api.info.license"))
                                   .licenseUrl(env.getProperty("swagger.api.info.licenseUrl"))
                                   .version(env.getProperty("swagger.api.version"))
                                   .build();
    }

    private Contact getContactInfo() {
        return new Contact(env.getProperty("swagger.api.info.contact.name"),
                           env.getProperty("swagger.api.info.contact.url"),
                           env.getProperty("swagger.api.info.contact.email"));
    }

}

package com.bachelor.bachelor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
@SpringBootApplication
public class BachelorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BachelorApplication.class, args);
    }

}

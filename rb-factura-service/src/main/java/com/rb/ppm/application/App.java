package com.rb.ppm.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.rb.ppm.application.rest",
        "com.rb.ppm.core.services",
        "com.rb.ppm.application.config"
})
@EnableJpaRepositories(basePackages = "com.rb.ppm.core.repository")
@EntityScan(basePackages = {"com.rb.ppm.core.domain"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
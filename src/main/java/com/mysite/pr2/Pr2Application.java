package com.mysite.pr2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Pr2Application {
    public static void main(String[] args) {
        SpringApplication.run(Pr2Application.class, args);
    }
}

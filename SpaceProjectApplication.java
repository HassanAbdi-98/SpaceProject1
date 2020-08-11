package com.space.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.space.controllers",
        "com.space.repositories",
        "com.space.services",
        "com.space.domains"})

@EnableJpaRepositories("com.space.repositories")
@EntityScan("com.space.domains")
public class SpaceProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpaceProjectApplication.class, args);
    }

}

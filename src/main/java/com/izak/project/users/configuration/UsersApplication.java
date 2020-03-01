package com.izak.project.users.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application start point
 *
 * @author Mohasin Kazi
 * @since 1st March 2020
 */
@SpringBootApplication(scanBasePackages = "com.izak.project.users")
@EnableJpaRepositories(basePackages = "com.izak.project.users.repositories")
@EntityScan(basePackages = "com.izak.project.users.entities")
public class UsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }
    // TODO [MK] add servlet config for war deployment compatibility

}

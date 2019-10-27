package com.juanzarate.keycloakSpringMiddleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Spring boot application start up class. You may run this class to start the
 * application.
 * <p>
 * We are excluding {@link SecurityAutoConfiguration} and
 * {@link UserDetailsServiceAutoConfiguration} to disable spring default basic
 * authentication.
 * </p>
 * Note: If you are using Spring 1.x you may exclude only
 * {@link SecurityAutoConfiguration}.
 */
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class })
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
package com.bridgelabz.userregistration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class UserRegistrationApplication {

    public static void main(String[] args) {
       ApplicationContext context=
               SpringApplication.run(UserRegistrationApplication.class, args);
       log.info("User Registration Started in {} Environment",context.getEnvironment()
               .getProperty("enviroment"));
       log.info("User Registration App started");
    }

}

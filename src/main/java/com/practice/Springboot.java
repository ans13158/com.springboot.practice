package com.practice;

import org.apache.logging.slf4j.SLF4JLoggingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot {
    private static Logger logger = LoggerFactory.getLogger(Springboot.class);

    public static void main(String... args) {
        SpringApplication.run(Springboot.class, args);
        System.out.println("Server up and running");
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");
    }
}

package com.dany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaThymeleafCurdApplication {
    protected static final Logger logger = LoggerFactory.getLogger(JpaThymeleafCurdApplication.class);

    public static void main(String[] args) {
        logger.info("SpringBoot开始加载");
        SpringApplication.run(JpaThymeleafCurdApplication.class, args);
        logger.info("SpringBoot加载完毕");
    }
}

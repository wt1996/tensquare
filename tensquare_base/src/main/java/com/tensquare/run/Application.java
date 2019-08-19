package com.tensquare.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @ClassName Application
 * @Auth 桃子
 * @Date 2019-8-19 14:20
 * @Version 1.0
 * @Description
 **/
@SpringBootApplication
@ComponentScan("com.tensquare")
@EnableJpaRepositories("com.tensquare.dao")
@EntityScan("com.tensquare.pojo")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}

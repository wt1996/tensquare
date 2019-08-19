package com.tensquare.config;

import com.tensquare.entity.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName BeanConfiguration
 * @Auth 桃子
 * @Date 2019-8-19 14:22
 * @Version 1.0
 * @Description  一些@Bean注入的类配置
 **/
@Configuration
public class BeanConfiguration {

    //分布式ID的创建类
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }

}

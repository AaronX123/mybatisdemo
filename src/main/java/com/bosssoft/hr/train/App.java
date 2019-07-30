package com.bosssoft.hr.train;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * SpringBoot的入口
 * @author aaron
 * @since 2019/7/24
 *
 */
@MapperScan("com.bosssoft.hr.train.mapper")
@SpringBootApplication(scanBasePackages= {"com.bosssoft.hr.train"})
@RestController
public class App {

    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }

}

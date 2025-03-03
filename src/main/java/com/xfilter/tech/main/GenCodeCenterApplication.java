package com.xfilter.tech.main;

import com.xfilter.tech.constants.CommonFunction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {"com.xfilter.tech.api"})
public class GenCodeCenterApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GenCodeCenterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("GenCodeCenterApplication|HelloWorld");
        System.out.println(CommonFunction.getGreetingConsole());
    }
}

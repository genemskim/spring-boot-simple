package com.example.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

@SpringBootApplication
public class SpringBootSimpleApplication implements CommandLineRunner, ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(
            SpringBootSimpleApplication.class);

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringBootSimpleApplication.class, args);
    }

    @Bean
    String info() {
        return "그냥 간단한 문자열 빈입니다";
    }

    @Autowired
    String info;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("## > ApplicationRunner 구현체");
        log.info("info 빈에 엑세스:" + info);
        args.getNonOptionArgs().forEach(file -> log.info(file));
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("## > CommnadRunner 구현체...");
        log.info("info 빈에 엑세스:"+info);
        for(String arg:args)
            log.info(arg);
    }
}
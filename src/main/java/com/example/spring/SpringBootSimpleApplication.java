package com.example.spring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class SpringBootSimpleApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootSimpleApplication.class);
        // 더 많은 기능은 여기에 추가
        app.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                out.print("\n\n\t나만의 멋진 배너랍니다!\n\n".toUpperCase());
            }
        });
        app.run(args);
    }

}

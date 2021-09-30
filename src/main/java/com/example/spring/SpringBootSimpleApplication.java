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

// class version 11
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


//public class SpringBootSimpleApplication {
//
//    public static void main(String[] args) {
//
        // class version 4
//        SpringApplication app = new SpringApplication(SpringBootSimpleApplication.class);
//        // 더 많은 기능은 여기에 추가
//        app.setBanner(new Banner() {
//            @Override
//            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//                out.print("\n\n\t나만의 멋진 배너랍니다!\n\n".toUpperCase());
//            }
//        });
//
//        app.run(args);

//        new SpringApplicationBuilder()
//                .bannerMode(Banner.Mode.OFF)
//                .sources(SpringBootSimpleApplication.class)
//                .run(args);

        // class version 5
//        Logger log = LoggerFactory.getLogger(SpringBootSimpleApplication.class);
//        new SpringApplicationBuilder(SpringBootSimpleApplication.class)
//                .listeners(new ApplicationListener<ApplicationEvent>() {
//
//                    @Override
//                    public void onApplicationEvent(ApplicationEvent event) {
//                        log.info("### > " + event.getClass().getCanonicalName());
//                    }
//                })
//                .run(args);

        // class version 10
//        SpringApplication.run(SpringBootSimpleApplication.class, args);
//    }

    // class version 10
//    @Component
//    class MyCompnent {
//
//        private final Logger log = LoggerFactory.getLogger(MyCompnent.class);
//
//        @Autowired
//        public MyCompnent(ApplicationArguments args) {
//            boolean enable = args.containsOption("enable");
//            if (enable)
//                log.info("## > enable 옵션을 주셨네요!!");
//
//            List<String> _args = args.getNonOptionArgs();
//            log.info("## > 다른인자 ...");
//            if(!_args.isEmpty())
//                _args.forEach(file -> log.info(file));
//        }
//    }

//}


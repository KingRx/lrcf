package com.lrcf.yhb.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Administrator on 2017/6/13.
 */
@SpringBootApplication
@ImportResource({"classpath:dubbo-services.xml"})
@MapperScan(basePackages = { "com.lrcf.yhb.dao.mapper"})
public class YHBServiceApplication {

//    private static final Logger logger = LoggerFactory.getLogger(Application.class);
//
//    @Bean
//    public CountDownLatch closeLatch() {
//        return new CountDownLatch(1);
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//
//        ApplicationContext ctx = new SpringApplicationBuilder().sources(Application.class).web(false).run(args);
//
//        logger.info("项目启动!");
//
//        CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
//        closeLatch.await();
//    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(YHBServiceApplication.class, args);
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}

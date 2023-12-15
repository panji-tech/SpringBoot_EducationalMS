package com.liujiajun;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableCaching
@MapperScan("com.liujiajun.mapper")
@Slf4j
public class SpringbootEduApplication {

    public static void main(String[] args) throws UnknownHostException {
        log.info("服务开始启动~");
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootEduApplication.class, args);
        ConfigurableEnvironment env = applicationContext.getEnvironment();

        log.info("\n---------------- 关注公众号 ITSource每日分享,每天分享一个 IT 资源------------------------------------------\n\t" +
                        "Application: is running! Access URLs:\n\t" +
                        "后端管理员地址: \t\thttp://127.0.0.1:{}/login\n\t"+
                        "----------------------------------------------------------",
                env.getProperty("server.port")
        );
        log.info("-------服务启动完成:{}-------", InetAddress.getLocalHost().getHostAddress());
    }

}

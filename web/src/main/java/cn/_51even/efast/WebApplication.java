package cn._51even.efast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        //解决ES与redis包冲突问题
//        System.setProperty("elasticsearch.set.netty.runtime.available.processors", "false");
        SpringApplication.run(WebApplication.class,args);
    }

}

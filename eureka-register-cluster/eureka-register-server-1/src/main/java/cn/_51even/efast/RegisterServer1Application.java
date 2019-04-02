package cn._51even.efast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegisterServer1Application {

    public static void main(String[] args) {
        SpringApplication.run(RegisterServer1Application.class,args);
    }
}

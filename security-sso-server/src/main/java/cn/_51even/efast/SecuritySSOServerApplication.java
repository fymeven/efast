package cn._51even.efast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SecuritySSOServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecuritySSOServerApplication.class,args);
    }

}

package cn._51even.efast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@EnableDiscoveryClient
@SpringBootApplication
public class FastDFSFileServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastDFSFileServerApplication.class,args);
    }

}

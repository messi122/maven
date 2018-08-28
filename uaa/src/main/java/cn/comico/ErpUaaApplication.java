package cn.comico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EntityScan(value = "cn.comico.set")
@SpringBootApplication
public class ErpUaaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpUaaApplication.class);
    }
}

package cn.comico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableCaching
@EnableHystrixDashboard
@EnableHystrix
@EnableFeignClients
@EnableSwagger2
@EntityScan(value = {"cn.comico.set", "cn.comico.info"})
@ComponentScan(value = {"cn.comico", "cn.comico.erp.commons.config.resource", "cn.comico.erp.commons.config.swagger2", "cn.comico.erp.commons.config.bean"})
@SpringBootApplication

@EnableJpaRepositories
public class SetServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SetServerApplication.class);
    }

}

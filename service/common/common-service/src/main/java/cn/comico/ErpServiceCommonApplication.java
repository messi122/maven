package cn.comico;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCaching
@EnableHystrixDashboard
@EnableHystrix
@EnableFeignClients
@EnableSwagger2
@EntityScan(value = "cn.comico.common")
@ComponentScan(value = {"cn.comico", "cn.comico.maven.commons.config.resource", "cn.comico.maven.commons.config.swagger2", "cn.comico.maven.commons.config.bean"})
@SpringBootApplication
@EnableJpaRepositories
public class ErpServiceCommonApplication {

    private static final Logger log = LoggerFactory.getLogger(ErpServiceCommonApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ErpServiceCommonApplication.class, args);
        log.info("{}", "successful");
    }
}

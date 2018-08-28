package cn.comico.erp.commons.config.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* 
* @author      changhuanhu
* @Description swagger2 自动生成API文档配置
* @Param 
* @exception   
* @return      
* @Date 2018/7/6 17:16
**/
@Configuration
public class Swagger2Config {


    @Bean
    public Docket docket() {
        //添加请求头access_token
        ParameterBuilder tokenHeader = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<Parameter>();
        tokenHeader.name("Authorization").description("access_token").defaultValue("Bearer ")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        Collections.addAll(parameters, tokenHeader.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//                .apis(RequestHandlerSelectors.basePackage("cn.comico.erp.service"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger2构建的erp-api文档")
                .description("简单优雅的restful风格")
                .termsOfServiceUrl("www.comicont.com")
                .version("1.0")
                .build();
    }

}

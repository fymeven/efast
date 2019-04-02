package cn._51even.efast;

import cn._51even.efast.shiro_cas.config.JWTConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger {
    @Value("${swagger.enabled}")
    private Boolean swaggerEnabled;

    @Resource
    private JWTConfig jwtConfig;

    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList();
        tokenPar.name(jwtConfig.getHeader()).description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .enable(swaggerEnabled).select()
                .apis(RequestHandlerSelectors.basePackage("cn._51even.efast.message.controller"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars).pathMapping("/");
    }

    @SuppressWarnings("deprecation")
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("消息服务平台")
                .description("Swagger接口文档")
                .version("1.0")
                .build();
    }
}

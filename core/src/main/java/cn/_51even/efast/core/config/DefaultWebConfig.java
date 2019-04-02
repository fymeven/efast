//package cn._51even.efast.core.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * Created by Administrator on 2018/5/19.
// */
//@Configuration
//public class DefaultWebConfig implements WebMvcConfigurer {
//
//    /**
//     * 静态资源配置
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//    /**
//     * 跨域CORS配置
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        CorsRegistration corsRegistration = registry.addMapping("/**");
//        corsRegistration.allowedOrigins("*");
//        corsRegistration.allowedHeaders("*");
//        corsRegistration.allowedMethods("*");
//        corsRegistration.allowCredentials(true);
//        corsRegistration.maxAge(3600L);
//    }
//
//}

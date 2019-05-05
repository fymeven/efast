package cn._51even.efast.gateway_proxy.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * 限流规则配置
 */
@Configuration
public class LimiterKeyResolver {

    /**
     * 使用请求header中的token参数限流
     * @return
     */
//    @Bean
//    public KeyResolver headerKeyResolver(){
//        return exchange -> Mono.just(exchange.getRequest().getHeaders().getFirst("token"));
//    }

    /**
     * 使用ip地址进行限流
     * @return
     */
    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}

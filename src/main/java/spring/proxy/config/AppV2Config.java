package spring.proxy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.proxy.app.v2.*;

@Configuration
public class AppV2Config {
    @Bean
    public OrderControllerV2 orderControllerV2(){
        return new OrderControllerV2(orderServiceV2());
    }

    private OrderServiceV2 orderServiceV2() {
        return new OrderServiceV2(orderRepositoryV2());
    }

    private OrderRepositoryV2 orderRepositoryV2() {
        return new OrderRepositoryV2();
    }
}

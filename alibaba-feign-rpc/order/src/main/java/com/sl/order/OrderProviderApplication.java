package com.sl.order;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderProviderApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * @description 设置负载策略, 默认轮询
     * new RetryRule(); 具备重试机制的实例选择功能morning采用的轮训
     * new RandomRule(); 随机策略
     * new RoundRobinRule(); 轮询(默认)
     **/
    @Bean
    public IRule IRule() {
        return new RoundRobinRule();
    }
}

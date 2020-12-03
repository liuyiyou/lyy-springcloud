package cn.liuyiyou.cloud.app.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/26
 * @version: V1.0
 */
@RibbonClient(name = "server-base-consumer",configuration = LoadBalacneConfig.class)
public class RibbonClientConfig {


    /**
     * 开启客户端负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

package cn.liuyiyou.cloud.server.base.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
//@EnableCircuitBreaker
public class ServerBaseConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServerBaseConsumerApplication.class, args);
  }

  @Bean
  /**
   * 开启客户端负载均衡
   */
  @LoadBalanced
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }

}

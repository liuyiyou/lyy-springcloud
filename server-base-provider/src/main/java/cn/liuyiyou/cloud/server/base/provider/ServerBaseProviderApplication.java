package cn.liuyiyou.cloud.server.base.provider;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class ServerBaseProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServerBaseProviderApplication.class, args);
  }

  @Autowired
  private DiscoveryClient discoveryClient;

  @Bean
  /**
   * 开启客户端负载均衡
   */
  @LoadBalanced
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @GetMapping("/")
  public List<String> home() {
    List<String> services = discoveryClient.getServices();
    services.add("current is server-base-provider");
    return services;
  }

}

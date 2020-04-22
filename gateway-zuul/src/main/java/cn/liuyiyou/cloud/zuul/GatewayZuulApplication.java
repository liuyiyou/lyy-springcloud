package cn.liuyiyou.cloud.zuul;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableZuulProxy
@SpringBootApplication
@RestController
public class GatewayZuulApplication {

  public static void main(String[] args) {
    SpringApplication.run(GatewayZuulApplication.class, args);
  }

  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/")
  public List<String> home() {
    return discoveryClient.getServices();
  }

}

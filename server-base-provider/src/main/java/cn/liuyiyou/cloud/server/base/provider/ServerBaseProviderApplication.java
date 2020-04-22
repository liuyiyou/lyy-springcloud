package cn.liuyiyou.cloud.server.base.provider;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServerBaseProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServerBaseProviderApplication.class, args);
  }

  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/")
  public List<String> home() {
    List<String> services = discoveryClient.getServices();
    services.add("current is server-base-provider");
    return services;
  }

}

package cn.liuyiyou.cloud.server.base.consumer.web;


import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@RestController
@Slf4j
public class BaseConsumerController  extends AbstractBaseController{

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private DiscoveryClient discoveryClient;

  /**
   * 调用其他微服务  http://localhost:8081/gateway/api/callBaseService  因为使用了自定义负载均衡，该方法不可用
   */
  @GetMapping("/callBaseService")
  public String callBaseService() {
    List<String> services = discoveryClient.getServices();
    if (!services.isEmpty()) {
      ServiceInstance instance = discoveryClient.getInstances("server-base-provider").get(0);
      String uri = "http://" + instance.getHost() + ":" + instance.getPort() +  "/base/baseService";
      log.info("url::{}", uri);
      String result = restTemplate.getForEntity(uri, String.class).getBody();
      return result;
    } else {
      return "no service";
    }
  }
}

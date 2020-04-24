package cn.liuyiyou.cloud.server.base.consumer.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/24
 * @version: V1.0
 */
@RestController
@Slf4j
public class BaseRobbinController extends AbstractBaseController{

  @Autowired
  private RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "baseFallBack")
  @GetMapping("/callBaseServiceByRobbin")
  public String callBaseService() {
    return restTemplate.getForEntity("http://server-base-provider/base/baseService", String.class)
        .getBody();
  }

}

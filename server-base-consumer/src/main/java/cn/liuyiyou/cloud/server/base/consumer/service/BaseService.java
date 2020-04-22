package cn.liuyiyou.cloud.server.base.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/22
 * @version: V1.0
 */
@Service
@Slf4j
public class BaseService {

  @Autowired
  private RestTemplate restTemplate;


  @HystrixCommand(fallbackMethod = "baseFallBack")
  public String callBaseService() {
//    try {
//      //触发熔断机制
//      Thread.sleep(5000L);
//    } catch (InterruptedException e) {
//      log.error("",e);
//    }
    return restTemplate.getForEntity("http://server-base-provider/base", String.class)
        .getBody();
  }

  private String baseFallBack() {
    return "error";
  }
}

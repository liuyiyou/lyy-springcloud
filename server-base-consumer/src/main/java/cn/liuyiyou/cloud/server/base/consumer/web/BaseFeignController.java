package cn.liuyiyou.cloud.server.base.consumer.web;

import cn.liuyiyou.cloud.server.base.consumer.api.FeighServiceClient;
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
public class BaseFeignController extends AbstractBaseController{

  @Autowired
  private FeighServiceClient feighServiceClient;

  @HystrixCommand(fallbackMethod = "baseFallBack")
  @GetMapping("/callBaseServiceByFeign")
  public String callBaseService() {
    return feighServiceClient.feighService("abc");
  }

}

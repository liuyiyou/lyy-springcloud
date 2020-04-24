package cn.liuyiyou.cloud.server.base.provider.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这个Controller和其他Controller并没有什么不同，feigh主要是声明式客户端
 *
 * @author: liuyiyou.cn
 * @date: 2020/4/23
 * @version: V1.0
 */
@RestController
@RequestMapping("/feigh-service")
public class FeignServiceController {


  @RequestMapping(value = "/instance/{serviceId}",method = RequestMethod.GET)
  public String feighService(@PathVariable("serviceId") String serviceId) {
    return serviceId;
  }
}

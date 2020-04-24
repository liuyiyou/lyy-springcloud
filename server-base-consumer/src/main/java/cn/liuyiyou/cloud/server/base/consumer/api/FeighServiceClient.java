package cn.liuyiyou.cloud.server.base.consumer.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/23
 * @version: V1.0
 */
// server-base-provider 对应的服务名称，表示需要调用从server-base-provider的接口
@FeignClient("server-base-provider")
@RequestMapping("/feigh-service")
public interface FeighServiceClient {

  @RequestMapping(value = "/instance/{serviceId}",method = RequestMethod.GET)
  String feighService(@PathVariable("serviceId") String serviceId);
}

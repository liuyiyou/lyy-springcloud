package cn.liuyiyou.cloud.server.base.consumer.api;

import cn.liuyiyou.cloud.server.base.consumer.response.ResultEntity;
import cn.liuyiyou.cloud.server.base.consumer.response.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/23
 * @version: V1.0
 */
// server-base-provider 对应的服务名称，表示需要调用从server-base-provider的接口
//@FeignClient(value = "server-base-provider",url = "http://192.168.36.107:9001")
@FeignClient(value = "server-base-provider")

@RequestMapping("/feigh-service")
@Component
public interface FeighServiceClient {

    @RequestMapping(value = "/instance/{serviceId}", method = RequestMethod.GET)
    String feighService(@PathVariable("serviceId") String serviceId);

    @RequestMapping(value = "/getUserWithWrap", method = RequestMethod.GET)
    ResultEntity<String> getUserWithWrap();

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    User getUser();

    @RequestMapping(value = "/getLongReq", method = RequestMethod.GET)
    User getLongReq();
}

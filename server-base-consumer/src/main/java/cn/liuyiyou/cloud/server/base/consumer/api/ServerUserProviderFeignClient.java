package cn.liuyiyou.cloud.server.base.consumer.api;

import cn.liuyiyou.cloud.server.base.consumer.response.ResultEntity;
import cn.liuyiyou.cloud.server.base.consumer.response.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
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
@FeignClient(value = "server-user-provider")
@Component
public interface ServerUserProviderFeignClient {

    @GetMapping("/user/feigh-service/test")
    String time() throws InterruptedException;

}

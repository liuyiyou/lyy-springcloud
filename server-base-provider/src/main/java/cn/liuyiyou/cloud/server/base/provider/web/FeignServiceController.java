package cn.liuyiyou.cloud.server.base.provider.web;

import cn.liuyiyou.cloud.server.base.provider.entity.User;
import cn.liuyiyou.cloud.server.base.provider.response.ResultEntity;
import org.springframework.web.bind.annotation.GetMapping;
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


    //http://localhost:8081/gateway/api-base/feigh-service/instance/SERVER-BASE-CONSUMER
    @RequestMapping(value = "/instance/{serviceId}", method = RequestMethod.GET)
    public String feighService(@PathVariable("serviceId") String serviceId) throws InterruptedException {
        //测试feign时间
        Thread.sleep(5000L);
        return serviceId;
    }


    @GetMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("lyy");
        return user;
    }

    @GetMapping("/getLongReq")
    public User getLongReq() throws InterruptedException {
        Thread.sleep(5000L);
        User user = new User();
        user.setId(1);
        user.setName("lyy");
        return user;
    }

    @GetMapping("/getUserWithWrap")
    public ResultEntity<String> getUserWithWrap() {
        System.out.println("xxxx");
        ResultEntity<String> userResultEntity = new ResultEntity<>(200, "hello");
        return userResultEntity;
    }
}

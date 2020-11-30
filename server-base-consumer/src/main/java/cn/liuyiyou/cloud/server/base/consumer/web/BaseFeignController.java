package cn.liuyiyou.cloud.server.base.consumer.web;

import cn.liuyiyou.cloud.server.base.consumer.api.FeighServiceClient;
import cn.liuyiyou.cloud.server.base.consumer.response.ResultEntity;
import cn.liuyiyou.cloud.server.base.consumer.response.dto.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/24
 * @version: V1.0
 */
@RestController
@Slf4j
public class BaseFeignController extends AbstractBaseController {

    @Autowired
    private FeighServiceClient feighServiceClient;


    /**
     * 测试超时
     *
     * # Feign配置
     *
     * feign.okhttp.enabled=true
     * feign.httpclient.enabled=false
     *
     * ribbon.okhttp.enabled=true
     *
     * # 请求连接的超时时间 默认的时间为 1 秒
     * ribbon.ConnectTimeout=10000
     * # 请求处理的超时时间
     * ribbon.ReadTimeout=10000
     * @return
     */
    @GetMapping("/getLongReq")
    public User getLongReq() {
        log.info("http://localhost:8081/gateway/api/callBaseServiceByFeign");
        User user = feighServiceClient.getLongReq();
        return user;
    }

    //http://localhost:8081/gateway/api/callBaseServiceByFeign
//    @HystrixCommand(fallbackMethod = "baseFallBack")
    @GetMapping("/callBaseServiceByFeign")
    public String callBaseService() {
        log.info("http://localhost:8081/gateway/api/callBaseServiceByFeign");
        return feighServiceClient.feighService("abc");
    }

    @GetMapping("/getUser")
    public User getUser() {
        log.info("http://localhost:8081/gateway/api/callBaseServiceByFeign");
        User user = feighServiceClient.getUser();
        return user;
    }

    @GetMapping("/getUserWithWrap")
    public ResultEntity getUserWithWrap() {
        log.info("ddddddign");
        ResultEntity<String> userWithWrap = feighServiceClient.getUserWithWrap();
        log.info(userWithWrap.toString());
        return userWithWrap;
    }



}

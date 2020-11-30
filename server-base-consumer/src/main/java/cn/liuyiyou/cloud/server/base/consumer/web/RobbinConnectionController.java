package cn.liuyiyou.cloud.server.base.consumer.web;

import cn.liuyiyou.cloud.server.base.consumer.api.ServerBaseProviderFeignClient;
import cn.liuyiyou.cloud.server.base.consumer.api.ServerUserProviderFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/24
 * @version: V1.0
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class RobbinConnectionController extends AbstractBaseController {

    private final ServerBaseProviderFeignClient serverBaseProviderFeignClient;
    private final ServerUserProviderFeignClient serverUserProviderFeignClient;

    @GetMapping("/baseTime")
    public String baseTime() throws InterruptedException {
        return serverBaseProviderFeignClient.time();
    }

    @GetMapping("/userTime")
    public String userTime() throws InterruptedException {
        return serverUserProviderFeignClient.time();
    }

}

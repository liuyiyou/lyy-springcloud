package cn.liuyiyou.cloud.server.base.provider.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/11/30
 * @version: V1.0
 */
@RestController
@RequestMapping("/base/feigh-service")
public class RibbonConnectionController {

    @GetMapping("/test")
    public String time() throws InterruptedException {
        Thread.sleep(2000L);
        return "success";
    }
}

package cn.liuyiyou.cloud.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/11/30
 * @version: V1.0
 */
@RestController
@RequestMapping("/user/feigh-service")
public class RibbonConnectionController {


    @GetMapping("/test")
    public String time() throws InterruptedException {
        Thread.sleep(5000L);
        return "success";
    }


}

package cn.liuyiyou.cloud.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/7
 * @version: V1.0
 */
@RestController
public class AppController {


    /**
     * 通过网关访问：http://localhost:8081/gateway/app/hello
     * 不通过网关访问：http://localhost:9000/hello
     * @return
     */
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}

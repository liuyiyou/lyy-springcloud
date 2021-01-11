package cn.liuyiyou.cloud.app.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
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


    @GetMapping("/headerTest")
    public Boolean test(HttpServletRequest request){
        String gatewayCache =  request.getHeader("Gateway-Cache");
        boolean cache = StringUtils.isNotBlank(gatewayCache) && gatewayCache.equals("false") ? false : true;
        System.out.println(cache);
        return cache;
    }

}

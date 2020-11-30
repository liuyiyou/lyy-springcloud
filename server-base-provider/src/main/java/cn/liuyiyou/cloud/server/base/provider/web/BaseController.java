package cn.liuyiyou.cloud.server.base.provider.web;

import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/22
 * @version: V1.0
 */
@RestController
@RequestMapping("/base")
@Slf4j
public class BaseController {


    //http://localhost:8081/gateway/api-base/base/baseService
    @GetMapping("/baseService")
    public String baseService() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String serverEndpoint = request.getServerName();
        log.info("serverEndpoint:{}",serverEndpoint);
        return "cn.liuyiyou.cloud.server.base.provider.web.BaseController#baseService()";
    }


}

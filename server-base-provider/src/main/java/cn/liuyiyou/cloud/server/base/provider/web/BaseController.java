package cn.liuyiyou.cloud.server.base.provider.web;

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
public class BaseController {

  //http://localhost:8081/gateway/api-base/base/baseService
  @GetMapping("/baseService")
  public String baseService() {
    return "cn.liuyiyou.cloud.server.base.provider.web.BaseController#baseService()";
  }
}

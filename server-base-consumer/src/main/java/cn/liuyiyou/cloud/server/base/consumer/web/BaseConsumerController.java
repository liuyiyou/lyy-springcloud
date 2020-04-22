package cn.liuyiyou.cloud.server.base.consumer.web;


import cn.liuyiyou.cloud.server.base.consumer.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@Slf4j
public class BaseConsumerController {


  @Autowired
  private BaseService baseService;


  @GetMapping("/callBaseService")
  public String callBaseService() {
    return baseService.callBaseService();
  }
}

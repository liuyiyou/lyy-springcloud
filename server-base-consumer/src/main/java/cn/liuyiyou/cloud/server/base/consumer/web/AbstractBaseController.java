package cn.liuyiyou.cloud.server.base.consumer.web;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/24
 * @version: V1.0
 */
@Slf4j
public class AbstractBaseController {

  /**
   * 触发熔断机制的时候调用
   * @return
   */
  private String baseFallBack() {
    log.error("熔断了。。。。。。");
    return "error";
  }
}

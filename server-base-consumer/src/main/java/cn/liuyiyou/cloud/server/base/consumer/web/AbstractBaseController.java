package cn.liuyiyou.cloud.server.base.consumer.web;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/24
 * @version: V1.0
 */
@Slf4j
public class AbstractBaseController  extends ZuulFilter {

  /**
   * 触发熔断机制的时候调用
   * @return
   */
  private String baseFallBack() {
    log.error("熔断了。。。。。。");
    return "error";
  }

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    return null;
  }
}

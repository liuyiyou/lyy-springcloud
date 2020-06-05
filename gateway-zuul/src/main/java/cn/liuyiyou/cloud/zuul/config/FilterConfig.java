package cn.liuyiyou.cloud.zuul.config;

import cn.liuyiyou.cloud.zuul.filter.ErrorFilter;
import cn.liuyiyou.cloud.zuul.filter.PostFilter;
import cn.liuyiyou.cloud.zuul.filter.PreFilter;
import cn.liuyiyou.cloud.zuul.filter.RouteFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/5
 * @version: V1.0
 */
@Configuration
public class FilterConfig {


  @Bean
  public PreFilter preFilter() {
    return new PreFilter();
  }

  @Bean
  public PostFilter postFilter() {
    return new PostFilter();
  }

  @Bean
  public ErrorFilter errorFilter(){
    return new ErrorFilter();
  }

  @Bean
  public RouteFilter routeFilter(){
    return new RouteFilter();
  }
}

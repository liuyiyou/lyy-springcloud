package cn.liuyiyou.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/18
 * @version: V1.0
 */
@Slf4j
public class PreFilter extends ZuulFilter {

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
    if (RequestContext.getCurrentContext().sendZuulResponse()) {
      return true;
    }
    return false;
  }

  @Override
  public Object run() throws ZuulException {
    //获取上下文
    final RequestContext currentContext = RequestContext.getCurrentContext();
    final HttpServletRequest request = currentContext.getRequest();
    if (request.getMethod().equals("GET")) {
      //数据可以在这里进行换乘
      log.info("PreFilter");
    }
    return  null;
  }
}

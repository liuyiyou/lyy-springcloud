package cn.liuyiyou.cloud.zuul.routelocator;

import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * @author: liuyiyou.cn
 * @date: 2021/1/8
 * @version: V1.0
 */
public class DbRouteLocator extends SimpleRouteLocator {


    public DbRouteLocator(final String servletPath, final ZuulProperties properties) {
        super(servletPath, properties);
    }


}

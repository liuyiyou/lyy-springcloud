package cn.liuyiyou.cloud.app.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * Feign自定义拦截器
 *
 * @author: liuyiyou.cn
 * @date: 2020/4/26
 * @version: V1.0
 */
@Slf4j
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("通过Feign调用会打印日志.......");
    }
}

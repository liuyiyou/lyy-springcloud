package cn.liuyiyou.cloud.server.base.consumer.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/26
 * @version: V1.0
 */
@RibbonClient(name = "server-base-consumer",configuration = LoadBalacneConfig.class)
public class RibbonClientConfig {

}

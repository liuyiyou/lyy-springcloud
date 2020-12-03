package cn.liuyiyou.cloud.app.config;

import cn.liuyiyou.cloud.app.loadbalance.UserOneServerRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/26
 * @version: V1.0
 */
@Configuration
public class LoadBalacneConfig {


    @Bean
    public UserOneServerRule rule() {
        return new UserOneServerRule();
    }

}

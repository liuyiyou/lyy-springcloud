package cn.liuyiyou.cloud.app.config;

import cn.liuyiyou.cloud.app.feign.FeignBasicAuthRequestInterceptor;
import feign.Logger.Level;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/26
 * @version: V1.0
 */
@Configuration
@Import(FeignClientsConfiguration.class)
public class FeignConfiguration {

    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }

    @Bean
    Level logLevel() {
        return Level.FULL;
    }

}

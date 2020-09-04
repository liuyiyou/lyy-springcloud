package cn.liuyiyou.starter.autoconfigure.feign;

import feign.Logger.Level;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
@ConditionalOnProperty(prefix = "lyy.config.feign", name = "enable",
    havingValue = "true", matchIfMissing = true)
public class FeignAutoConfiguration {

    @Bean
    Level logLevel() {
        return Level.FULL;
    }


}

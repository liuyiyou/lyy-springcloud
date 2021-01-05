package cn.liuyiyou.starter;

import cn.liuyiyou.starter.properties.RunnerProperties;
import cn.liuyiyou.starter.properties.SwaggerProperties;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@Slf4j
@EnableAspectJAutoProxy
@ConditionalOnWebApplication
@ComponentScan
//启用SwaggerProperties配置功能，并加入到IOC容器中
@EnableConfigurationProperties({SwaggerProperties.class, RunnerProperties.class})
public class CloudAutoConfiguration {

    @Autowired
    private RunnerProperties runnerProperties;

    @PostConstruct
    public void sys() {
        log.info("加载cloud-autoconfigure成功:{}", runnerProperties.getName());
    }

}

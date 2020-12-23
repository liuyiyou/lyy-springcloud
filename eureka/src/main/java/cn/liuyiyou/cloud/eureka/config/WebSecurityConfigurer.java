package cn.liuyiyou.cloud.eureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/15
 * @version: V1.0
 */
//新版的security默认启用了csrf检验，要在eureka服务端那边配置security的csrf检验为false
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
//        http.authorizeRequests().anyRequest().authenticated().and().httpBasic(); //开启认证
    }
}


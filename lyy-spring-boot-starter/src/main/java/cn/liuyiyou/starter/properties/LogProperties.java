package cn.liuyiyou.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: liuyiyou.cn
 * @date: 2020/9/4
 * @version: V1.0
 */
@ConfigurationProperties("log")
public class LogProperties {

    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}

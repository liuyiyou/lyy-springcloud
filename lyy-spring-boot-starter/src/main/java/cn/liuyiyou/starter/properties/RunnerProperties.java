package cn.liuyiyou.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: liuyiyou.cn
 * @date: 2020/9/4
 * @version: V1.0
 */
@ConfigurationProperties(prefix = "run")
public class RunnerProperties {

    private String name = "liuyiyou";

    private Boolean popWindow = true;

    public Boolean getPopWindow() {
        return popWindow;
    }

    public void setPopWindow(Boolean popWindow) {
        this.popWindow = popWindow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package cn.liuyiyou.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liuyiyou
 */
@ConfigurationProperties(prefix = "lyy.swagger")
public class SwaggerProperties {

    private String basePackage = "cn.liuyiyou.**.controller";
    private String title = "Next Center API";
    private String description = " Center API Document Copyright © 2015-2020 By yanglaoban.";
    private String version = "1.0.0";
    private String author = "liuyiyou";
    private String url = "http://localhost:8080";
    private String email = "liuyiyou@yanglaoban.com";


    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

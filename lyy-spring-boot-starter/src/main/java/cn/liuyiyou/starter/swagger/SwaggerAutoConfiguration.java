package cn.liuyiyou.starter.swagger;

import cn.liuyiyou.starter.properties.SwaggerProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: liuyiyou.cn
 * @date: 2020/8/5
 * @version: V1.0
 */
@Configuration
@EnableOpenApi
@RequiredArgsConstructor
@Slf4j
@ConditionalOnWebApplication
@ComponentScan
@EnableConfigurationProperties({SwaggerProperties.class})
public class SwaggerAutoConfiguration {

    @Autowired
    private SwaggerProperties swagger;

    @PostConstruct
    public void sys() {
        log.info("加载swagger-autoconfigure成功:{}", swagger.getTitle());
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.OAS_30)
            .select()
            .apis(RequestHandlerSelectors.basePackage(swagger.getBasePackage()))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo(swagger))
            .alternateTypeRules(pageableTypeRule());
    }

    private AlternateTypeRule pageableTypeRule() {
        return AlternateTypeRules.newRule(Pageable.class, Page.class, 1);
    }


    @ApiModel
    public static class Page {

        @ApiModelProperty(value = "第page页,从1开始计数", example = "1")
        private Integer page;

        @ApiModelProperty(value = "每页数据数量", example = "10")
        private Integer size;

        @ApiModelProperty(
            "排序格式：GET /path/all?page=1&size=10&sort=id,desc&sort=name,desc&sort=weight,asc\n"
                + "等价于 GET /path/all?page=1&size=10&sort=id,name,desc&sort=weight,asc")
        private List<String> sort;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public List<String> getSort() {
            return sort;
        }

        public void setSort(List<String> sort) {
            this.sort = sort;
        }
    }

    private ApiInfo apiInfo(SwaggerProperties swagger) {
        return new ApiInfo(
            swagger.getTitle(),
            swagger.getDescription(),
            swagger.getVersion(),
            null,
            new Contact(swagger.getAuthor(), swagger.getUrl(), swagger.getEmail()),
            "1", "1", Collections.emptyList());
    }

}

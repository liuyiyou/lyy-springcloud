package cn.liuyiyou.cloud.reactive.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;

import java.lang.reflect.Method;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

/**
 * @author: liuyiyou.cn
 * @date: 2021/1/6
 * @version: V1.0
 */
@Configuration
public class CityHandler {

    @Bean
    public RouterFunction<?> helloRouterFunction() {
        return route(GET("/hello"), request ->
            ok().body(just("Hello World"), String.class))
            .andRoute(GET("/hello2"), request -> ok().body(just("Hello World2"), String.class));
    }

    public static void main(String[] args) {
        String url = "https://cmall.ibaboss.com/order/pay?orderId=xxxx&id?=xxxx";
        final String[] split = url.split("\\?");
        final String s = split[0];
        String  basePath = s.replace("order/pay", "");

        System.out.println(basePath);
    }

}

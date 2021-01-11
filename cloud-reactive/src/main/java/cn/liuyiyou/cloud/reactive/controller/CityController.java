package cn.liuyiyou.cloud.reactive.controller;

import cn.liuyiyou.cloud.reactive.entity.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author: liuyiyou.cn
 * @date: 2021/1/6
 * @version: V1.0
 */
@RestController
@RequestMapping("/citys/")
@Slf4j
public class CityController {

    @GetMapping
    public Mono<City> list() {
        return Mono.create(monoSink -> {
            monoSink.onCancel(() -> log.info("onCancel"));
            monoSink.onRequest(value -> log.info("onRequest:{}", value));
            monoSink.success(new City());
        });
    }

}

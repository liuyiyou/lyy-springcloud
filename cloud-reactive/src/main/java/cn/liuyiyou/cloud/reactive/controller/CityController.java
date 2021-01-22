package cn.liuyiyou.cloud.reactive.controller;

import cn.liuyiyou.cloud.reactive.entity.City;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
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

    @GetMapping("id")
    public Mono<City> get(@PathVariable Integer id) {
        return Mono.create(monoSink -> {
            monoSink.onCancel(() -> log.info("onCancel"));
            monoSink.onRequest(value -> log.info("onRequest:{}", value));
            monoSink.success(new City());
        });
    }

    @GetMapping
    public Flux<City> list() {
        List<City> cities = new ArrayList<>();
        IntStream.range(1, 4).forEach(i -> {
            City city = new City();
            city.setId(i);
            city.setName("City+" + i);
            cities.add(city);
        });
        return Flux.fromIterable(cities);
    }

}

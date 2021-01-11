package cn.liuyiyou.cloud.reactive.base;

import cn.liuyiyou.cloud.reactive.utils.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.Mono;
import reactor.core.publisher.UnicastProcessor;

/**
 * @author: liuyiyou.cn
 * @date: 2021/1/6
 * @version: V1.0
 */
@Slf4j
public class FluxProcessorExample {

    @Test
    @DisplayName("Mono创建")
    void simpleMonoCreate() {
        log.info("创建一个空的Mono");
        Mono<String> mono = Mono.empty();
        log.info(mono.block());
        log.info("使用just创建");
        Mono<String> mono1 = Mono.just("foo");
        log.info(mono1.block());

    }

    @Test
    @DisplayName("Flux创建")
    void simpleFluxCreate() {
        log.info("使用just方法创建");
        Flux<String> seql = Flux.just("foo", "bar", "foobar");
        final Disposable subscribe = seql.subscribe();
        log.info("" + subscribe.isDisposed());
        //使用List创建
        List<String> iterable = Arrays.asList("foo", "bar", "foobar");
        final Flux<String> stringFlux = Flux.fromIterable(iterable);
        stringFlux.subscribe(log::info);

        Flux<Integer> numberFrom = Flux.range(5, 3);
        numberFrom.subscribe(integer -> log.info(integer.toString()));

    }

    @Test
    void ifElse(){
        List<String> list = Arrays.asList("1","2","3");
        Optional.ofNullable(list).ifPresentOrElse(System.out::println, () -> System.out.println("xxx"));
    }


    @Test
    @DisplayName("订阅后的错误处理")
    void subscribOnError() {
        //设置在订户附加时生成四个值的 Flux
        Flux<Integer> ints = Flux.range(1, 4)
            // 使用Map处理一些值
            .map(i -> {
                if (i <= 3) {
                    return i;
                }
                throw new RuntimeException("Got to 4");
            });
        //订阅正常输出和异常输出
        ints.subscribe(System.out::println,
            error -> System.err.println("Error: " + error), () -> System.out.println("处理完成")); //因为发生异常，相当于没有完成，所以不会打印
    }


    @Test
    void test() {
        FluxProcessor<Integer, Integer> publisher = UnicastProcessor.create();
        publisher.onNext(1);
        publisher.onNext(2);
        publisher.doOnNext(value -> System.out.println("receive value:" + value)).subscribe();
    }

}

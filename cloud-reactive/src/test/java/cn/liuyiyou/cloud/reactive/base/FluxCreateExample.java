package cn.liuyiyou.cloud.reactive.base;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * @author: liuyiyou.cn
 * @date: 2021/1/15
 * @version: V1.0
 */
public class FluxCreateExample {


    @Test
    @DisplayName("假设我们想要接受一个英文人名，然后将所有的字母都转换为大写，并用得到的结果创建一个问候消息，并最终打印它")
    void printUserName() {
        Mono.just("Craig").map(String::toUpperCase).map(name -> "Hello:" + name).subscribe(System.out::println);
    }

    //创建操作
    @Test
    @DisplayName("使用静态just来创建")
    void createAFlux_just() {
        final Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Bannan", "Strawberry");
        fruitFlux
            .subscribe(f -> System.out.println("得到订阅:" + f));

        StepVerifier.create(fruitFlux)
            .expectNext("Apple", "Orange", "Grape", "Bannan", "Strawberry").verifyComplete();
    }


    @Test
    @DisplayName("使用数组来创建")
    void createAFlux_FromArray() {
        String[] s = new String[]{"Apple", "Orange", "Grape", "Bannan", "Strawberry"};
        final Flux<String> fruitFlux = Flux.fromArray(s);
        fruitFlux
            .subscribe(f -> System.out.println("得到订阅:" + f));

        StepVerifier.create(fruitFlux)
            .expectNext("Apple", "Orange", "Grape", "Bannan", "Strawberry").verifyComplete();
    }

    @Test
    @DisplayName("使用集合来创建")
    void createAFlux_FromCollection() {
        List<String> s = Arrays.asList("Apple", "Orange", "Grape", "Bannan", "Strawberry");
        final Flux<String> fruitFlux = Flux.fromIterable(s);
        fruitFlux
            .subscribe(f -> System.out.println("得到订阅:" + f));

        StepVerifier.create(fruitFlux)
            .expectNext("Apple", "Orange", "Grape", "Bannan", "Strawberry").verifyComplete();
    }


    @Test
    @DisplayName("使用流来创建")
    void createAFlux_FromStream() {
        Stream<String> s = Stream.of("Apple", "Orange", "Grape", "Bannan", "Strawberry");
        final Flux<String> fruitFlux = Flux.fromStream(s);
        //流和集合不同，
//        fruitFlux.subscribe(f -> System.out.println("得到订阅:" + f));

        StepVerifier.create(fruitFlux)
            .expectNext("Apple", "Orange", "Grape", "Bannan", "Strawberry").verifyComplete();
    }

    @Test
    @DisplayName("计数器")
    void createFlux_Range() {
        final Flux<Integer> range = Flux.range(1, 10);
        StepVerifier.create(range).expectNext(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).verifyComplete();
    }

    @Test
    @DisplayName("周期性")
    void createFlux_Interval() {
        final Flux<Long> interval = Flux.interval(Duration.ofSeconds(1)).take(5L);
        StepVerifier.create(interval).expectNext(0L, 1L, 2L, 3L, 4L).verifyComplete();
    }

}

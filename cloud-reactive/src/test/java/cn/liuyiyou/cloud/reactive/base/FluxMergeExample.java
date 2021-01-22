package cn.liuyiyou.cloud.reactive.base;

import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * @author: liuyiyou.cn
 * @date: 2021/1/15
 * @version: V1.0
 */
public class FluxMergeExample {


    @Test
    @DisplayName("合并流")
    void mergeFluxs() {
        Flux<String> chrarcterFlux = Flux.just("Gafield", "Kojak", "Barbossa")
            //每500ms发布一个条目
            .delayElements(Duration.ofMillis(500));
        Flux<String> footFlux = Flux.just("Lasagna", "Lollipops", "Apples")
            .delaySubscription(Duration.ofMillis(250))
            .delayElements(Duration.ofMillis(500));
        final Flux<String> stringFlux = chrarcterFlux.mergeWith(footFlux);
        StepVerifier.create(stringFlux)
            .expectNext("Gafield")
            .expectNext("Lasagna")
            .expectNext("Kojak")
            .expectNext("Lollipops")
            .expectNext("Barbossa")
            .expectNext("Apples")
            .verifyComplete();

    }

}

package com.zzmin.demoWebFlux.java;

import com.zzmin.demoWebFlux.util.LoggerJ;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxExample_java {
    public static void main(String[] args) {

        // 1. Flux - 여러개 data를 한번에 emit
        Flux.just(6, 9, 13)
                .map(num -> num % 2)
                .subscribe(remainder -> LoggerJ.info("# remainder: {}", remainder));


        // 2. filter연산자로 조건문 필터링, map연산자로 결과데이터 가공
        Flux.fromArray(new Integer[]{3, 6, 7, 9})
                .filter(num -> num > 6)
                .map(num -> num * 2)
                .subscribe(multiply -> LoggerJ.info("# multiply: {}", multiply));


        // 3. Mono 2개 합쳐서 Flux로 연산 - justOrEmpty연산자
        Flux<Object> flux =
                Mono.justOrEmpty(null)
                        .concatWith(Mono.justOrEmpty("Jobs"));
        flux.subscribe(data -> LoggerJ.info("# result: {}", data));

        // 4. collectList - 여러개 Flux를 합쳐서 LIST로 반환
        Flux.concat(
                        Flux.just("Venus"),
                        Flux.just("Earth"),
                        Flux.just("Mars"))
                .collectList()
                .subscribe(planetList -> LoggerJ.info("# Solar System: {}", planetList));

    }
}

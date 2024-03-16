package com.zzmin.demoWebFlux.java;

import com.zzmin.demoWebFlux.util.LoggerJ;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static reactor.core.publisher.Signal.subscribe;

public class FluxExample_java {
    public static void main(String[] args) {
        // 1. Flux.just - 여러개 data를 한번에 emit
        // * filter - 조건문 필터링
        // * map - 결과데이터 가공
        Flux.just(3, 6, 9, 13)
                .filter(num -> num > 6)
                .map(num -> num * 2)
                .subscribe(remainder -> LoggerJ.info("1. multiply: {}", remainder));

        // 2. fromArray - 배열을 처리
        Flux.fromArray(new Integer[]{1, 2, 3})
                .subscribe(multiply -> LoggerJ.info("2-1. Integer[] : {}", multiply));
        Flux.fromArray(new String[]{"one", "two", "three"})
                .subscribe(data -> LoggerJ.info("2-2. String[] : {}", data));

        // 3. fromIterable - Iterable을 처리
        // ex) ArrayList, ArrayBlockingQueue, HashSet, LinkedList, Stack ,TreeSet, Vector 등
        Flux.fromIterable(new ArrayList<>(Arrays.asList("one", "two", "three")))
                .subscribe(data -> LoggerJ.info("3. fromIterable : {}", data));

        // 4. concatWith - Mono 2개 합쳐서 Flux로 연산
        Flux<Object> flux = Mono.justOrEmpty(null)
                                .concatWith(Mono.just("Jobs"));
        flux.subscribe(data -> LoggerJ.info("4-1. concatWith(justOrEmpty + just) : {}", data));

        Flux<String> flux2 = Mono.just("zz")
                .concatWith(Mono.just("min"));
        flux2.subscribe(data -> LoggerJ.info("4-2. concatWith(just + just) : {}", data));

        // 5-1. concat + collectList
        // * concat - 여러 Fluxt를 합침
        // * collectList - 여러개 Flux를 합쳐서 LIST로 반환
        Flux.concat(
                        Flux.just("Venus"),
                        Flux.just("Earth"),
                        Flux.just("Mars"))
                .collectList()
                .subscribe(planetList -> LoggerJ.info("5-1. concat + collectList : {}", planetList));

        // 5-2. concat
        // * concat - 여러 Fluxt를 합침
        // * collectList - 여러개 Flux를 합쳐서 LIST로 반환
        Flux.concat(
                        Flux.just("Venus"),
                        Flux.just("Earth"),
                        Flux.just("Mars"))
                .subscribe(planetList -> LoggerJ.info("5-2. concat : {}", planetList));

    }
}

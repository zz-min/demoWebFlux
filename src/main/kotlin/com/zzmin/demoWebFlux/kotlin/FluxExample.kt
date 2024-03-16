package com.zzmin.demoWebFlux.kotlin

import com.zzmin.demoWebFlux.util.LoggerJ
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

//FluxExample_kotlin
fun main() {
    // 1. Flux.just - 여러개 data를 한번에 emit
    // * filter - 조건문 필터링
    // * map - 결과데이터 가공
    Flux.just(3, 6, 9, 13)
        .filter { num: Int -> num > 6 }
        .map { num: Int -> num * 2 }
        .subscribe { remainder: Int? -> LoggerJ.info("1. multiply: {}", remainder) }

    // 2. fromArray - 배열을 처리
    Flux.fromArray(arrayOf(1, 2, 3))
        .subscribe { multiply: Int? -> LoggerJ.info("2-1. arrayOf(정수) : {}", multiply) }
    Flux.fromArray(arrayOf("one", "two", "three"))
        .subscribe { data: String? -> LoggerJ.info("2-2. arrayOf(문자열) : {}", data) }

    // 3. fromIterable - Iterable을 처리
    // ex) ArrayList, ArrayBlockingQueue, HashSet, LinkedList, Stack ,TreeSet, Vector 등
    Flux.fromIterable(ArrayList(mutableListOf("one", "two", "three")))
        .subscribe { data: String? -> LoggerJ.info("3. fromIterable : {}", data) }

    // 4. concatWith - Mono 2개 합쳐서 Flux로 연산
    val flux = Mono.justOrEmpty<Any>(null)
                    .concatWith(Mono.just("Jobs"))
    flux.subscribe { data: Any? -> LoggerJ.info("4-1. concatWith(justOrEmpty + just) : {}", data) }

    val flux2 = Mono.just("zz")
                    .concatWith(Mono.just("min"))
    flux2.subscribe { data: String? -> LoggerJ.info("4-2. concatWith(just + just) : {}", data) }

    // 5-1. concat + collectList
    // * concat - 여러 Fluxt를 합침
    // * collectList - 여러개 Flux를 합쳐서 LIST로 반환
    Flux.concat(
        Flux.just("Venus"),
        Flux.just("Earth"),
        Flux.just("Mars")
    )
        .collectList()
        .subscribe { planetList: List<String>? -> LoggerJ.info("5-1. concat + collectList : {}", planetList) }

    // 5-2. concat
    // * concat - 여러 Fluxt를 합침
    // * collectList - 여러개 Flux를 합쳐서 LIST로 반환
    Flux.concat(
        Flux.just("Venus"),
        Flux.just("Earth"),
        Flux.just("Mars")
    )
        .subscribe { planetList: String? -> LoggerJ.info("5-2. concat : {}", planetList) }

}
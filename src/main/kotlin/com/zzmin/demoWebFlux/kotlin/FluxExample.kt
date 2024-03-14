package com.zzmin.demoWebFlux.kotlin

import com.zzmin.demoWebFlux.util.LoggerJ
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

//FluxExample_kotlin
fun main() {
    // 1. Flux - 여러개 data를 한번에 emit
    Flux.just(6, 9, 13)
        .map { num: Int -> num % 2 }
        .subscribe { remainder: Int? ->
            LoggerJ.info("# remainder: {}", remainder)
            //remainder: 0
            //remainder: 1
            //remainder: 1
        }


    // 2. filter연산자로 조건문 필터링, map연산자로 결과데이터 가공
    Flux.fromArray(arrayOf(3, 6, 7, 9))
        .filter { num: Int -> num > 6 } // 필터링 결과 : 7, 9
        .map { num: Int -> num * 2 } // 데이터 가공 결과 : 14, 18
        .subscribe { multiply: Int? ->
            LoggerJ.info("# multiply: {}", multiply)
            //multiply: 14
            //multiply: 18
        }


    // 3. Mono 2개 합쳐서 Flux로 연산 - justOrEmpty연산자
    val flux = Mono.justOrEmpty<Any>(null)
        .concatWith(Mono.justOrEmpty("Jobs"))
    flux.subscribe { data: Any? ->
        LoggerJ.info("# result: {}", data)
        //result: Jobs
    }

    // 4. collectList - 여러개 Flux를 합쳐서 LIST로 반환
    Flux.concat(
        Flux.just("Venus"),
        Flux.just("Earth"),
        Flux.just("Mars")
    )
        .collectList()
        .subscribe { planetList: List<String>? ->
            LoggerJ.info("# Solar System: {}", planetList)
            //Solar System: [Venus, Earth, Mars]
        }

}
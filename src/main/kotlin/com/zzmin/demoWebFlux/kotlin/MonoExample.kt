package com.zzmin.demoWebFlux.kotlin

import com.jayway.jsonpath.JsonPath
import com.zzmin.demoWebFlux.util.Logger
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import reactor.core.publisher.Mono
import java.net.URI


//MonoExample_kotlin
fun main() {
    println("=== zzmin start ===")


    // 1. Mono - 1개 data 생성후 emit
    Mono.just("Hello :D")
        .subscribe { message: String? -> Logger.info("# emitted data: {}", message)}


    // 2. Mono - data emit 없이 onComplete signal로 emit
    Mono.empty<String>()
        .subscribe (
            { message: String? -> Logger.info("# emitted data: {}", message)},
            { error -> Logger.onError(error)},
            { Logger.info("# emitted onComplete signal") }, // 빈 mono이기 떄문에 이 부분만 실행
        )


    // 3. map연산자로 결과데이터 가공
    val worldTimeUri = URI.create("http://worldtimeapi.org/api/timezone/Asia/Seoul")
    val restTemplate = RestTemplate()
    val headers = HttpHeaders().apply {
        accept = listOf(MediaType.APPLICATION_JSON)
    }

    Mono.just(restTemplate.exchange(worldTimeUri, HttpMethod.GET, HttpEntity<String>(headers), String::class.java))
        .map { response ->
            //val jsonContext = JsonPath.parse(response.body)
            //val dateTime = jsonContext.read<String>("$.datetime")
            val dateTime = JsonPath.parse(response.body).read<String>("$.datetime")
            dateTime // 가공된 데이터 반환
        }
        .subscribe (
            { data: String? -> Logger.info("# emitted data: {}", data)},//# emitted data: 2024-03-15T00:19:11.986867+09:00
            { error -> Logger.onError(error)},
            { Logger.info("# emitted onComplete signal") }, //# emitted onComplete signal
        )
}

// Mono : Publisher
// "Hello Reactor" : Data  Source
// just, empty : Operator
// subscribe : Subscribe 구독자

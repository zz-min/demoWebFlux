package com.zzmin.demoWebFlux.java;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.zzmin.demoWebFlux.util.LoggerJ;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;

public class MonoExample_java {
    public static void main(String[] args) {
        System.out.println("=== zzmin start ===");

        // 1. Mono - 1개 data 생성후 emit
        Mono.just("Hello :D")
                .subscribe(message-> LoggerJ.info("# emitted data: {}", message));


        // 2. Mono - data emit 없이 onComplete signal로 emit
        Mono.empty()
                .subscribe(
                        message -> LoggerJ.info("# emitted data: {}", message),
                        error -> LoggerJ.onError(error),
                        () -> LoggerJ.info("# emitted onComplete signal")// 빈 mono이기 떄문에 이 부분만 실행
                );


        // 3. map연산자로 결과데이터 가공
        URI worldTimeUri = UriComponentsBuilder.newInstance().scheme("http")
                .host("worldtimeapi.org")
                .port(80)
                .path("/api/timezone/Asia/Seoul")
                .build()
                .encode()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Mono.just(restTemplate.exchange(worldTimeUri, HttpMethod.GET, new HttpEntity<String>(headers), String.class))
                .map(response -> {
                    DocumentContext jsonContext = JsonPath.parse(response.getBody());
                    String dateTime = jsonContext.read("$.datetime");
                    return dateTime; //가공된 데이터 반환
                })
                .subscribe(
                        data -> LoggerJ.info("# emitted data: " + data),//# emitted data: 2024-03-14T00:26:22.759954+09:00
                        error -> LoggerJ.onError(error),
                        () -> LoggerJ.info("# emitted onComplete signal")//# emitted onComplete signal
                );
    }

    // Mono : Publisher
    // message "Hello Reactor" : Data  Source
    // just, empty, map : Operator
    // subscribe : Subscribe 구독자
}



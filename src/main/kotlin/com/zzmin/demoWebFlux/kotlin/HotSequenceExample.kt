package com.zzmin.demoWebFlux.kotlin

import com.zzmin.demoWebFlux.util.Logger
import reactor.core.publisher.Flux
import java.time.Duration
import java.util.stream.Stream

// HotSequence : Subscriber가 구독한 시점의 타임라인부터 emit가능 (지난데이터 사용 X)
fun main(){
    val concertFlux: Flux<String> =
        Flux.fromStream(Stream.of("Singer A", "Singer B", "Singer C", "Singer D", "Singer E"))
            .delayElements(Duration.ofSeconds(1)).share() //  share() 원본 Flux를 여러 Subscriber가 공유한다.

    concertFlux.subscribe { singer: String? ->
        Logger.info("# Subscriber1 is watching {}'s song.", singer)
    }

    Thread.sleep(2500)

    concertFlux.subscribe { singer: String? ->
        Logger.info("# Subscriber2 is watching {}'s song.", singer)
    }

    Thread.sleep(3000)

    /*
        # Subscriber1 is watching Singer A's song.
        # Subscriber1 is watching Singer B's song.
        # Subscriber1 is watching Singer C's song.
        # Subscriber2 is watching Singer C's song.
        # Subscriber1 is watching Singer D's song.
        # Subscriber2 is watching Singer D's song.
        # Subscriber1 is watching Singer E's song.
        # Subscriber2 is watching Singer E's song.

        즉, Subscriber1 : A -> B -> C -> D -> E (모든 데이터 emit)
            Subscriber2 :          C -> D -> E (2.5 sleep이후 데이터만 emit)
     */
}
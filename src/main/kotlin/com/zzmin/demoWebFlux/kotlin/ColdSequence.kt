package com.zzmin.demoWebFlux.kotlin

import com.zzmin.demoWebFlux.util.Logger
import reactor.core.publisher.Flux
import java.util.*


// ColdSequence : Subscriber가 구독한 시점 상관없이 모든 타임라인 data emit가능

fun main(){
    val coldFlux: Flux<String> = Flux.fromIterable(listOf("RED", "YELLOW", "PINK"))
        .map{ it -> it.lowercase(Locale.getDefault()) }

    coldFlux.subscribe { country: String? ->
        Logger.info("# Subscriber1: {}", country)
    }
    Thread.sleep(2500)

    Logger.info("-------------------------")
    coldFlux.subscribe { country: String? ->
        Logger.info( "# Subscriber2: {}", country)
    }

    /*
        # Subscriber1: red
        # Subscriber1: yellow
        # Subscriber1: pink
        -------------------------
        # Subscriber2: red
        # Subscriber2: yellow
        # Subscriber2: pink

        즉, Subscriber1, Subscriber2 모두 red -> yellow -> pink 모든 타임라인 emit
     */
}
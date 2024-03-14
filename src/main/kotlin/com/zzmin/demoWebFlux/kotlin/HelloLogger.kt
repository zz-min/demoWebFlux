package com.zzmin.demoWebFlux.kotlin

import com.zzmin.demoWebFlux.util.Logger

fun main() {
    // Logger.info 메서드 사용 예시
    Logger.info("This is a test message")

    // Logger.doOnNext 메서드 사용 예시
    Logger.doOnNext("Operator", "Data")

    // Logger.onNext 메서드 사용 예시
    Logger.onNext("Data")

    // Logger.onError 메서드 사용 예시
    val error = RuntimeException("Test error")
    Logger.onError(error)

    // Logger.onComplete 메서드 사용 예시
    Logger.onComplete("Task completed")
}
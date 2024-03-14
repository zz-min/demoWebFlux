package com.zzmin.demoWebFlux.util

import org.slf4j.LoggerFactory

object Logger {
    private val log = LoggerFactory.getLogger(Logger::class.java)

    fun info(data: Any?) {
        log.info("{}", data)
    }

    fun info(msg: String, data: Any?) {
        log.info(msg, data)
    }

    fun doOnNext(data: Any?) {
        log.info("# doOnNext(): {}", data)
    }

    fun doOnNext(operator: String, data: Any?) {
        log.info("# doOnNext() {}: {}", operator, data)
    }

    fun doOnNext(taskName: String, operator: String, data: Any?) {
        log.info("# doOnNext() {} {}: {}", taskName, operator, data)
    }

    fun doOnRequest(data: Any?) {
        log.info("# doOnRequest(): {}", data)
    }

    fun onNext(data: Any?) {
        log.info("# onNext(): {}", data)
    }

    fun onNext(data1: Any?, data2: Any?) {
        log.info("# onNext(): {} : {}", data1, data2)
    }

    fun onError(error: Throwable) {
        log.error("error happened: ", error)
    }

    fun onComplete() {
        log.error("# onComplete()")
    }

    fun onComplete(data: Any?) {
        log.info("# onComplete(): {}", data)
    }

    fun onNext(message: String, data: Any?) {
        log.info("# $message onNext(): {}", data)
    }

    fun filter(data: Any?) {
        log.info("# filter(): {}", data)
    }

    fun map(data: Any?) {
        log.info("# map(): {}", data)
    }
}

package com.zzmin.demoWebFlux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoWebFluxApplication

fun main(args: Array<String>) {
//	scrapNews()
	runApplication<DemoWebFluxApplication>(*args)
}

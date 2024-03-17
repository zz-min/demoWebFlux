package com.zzmin.demoWebFlux

import com.apple.eawt.Application
import org.junit.jupiter.api.Test
import org.springframework.boot.SpringApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.graphql.test.tester.HttpGraphQlTester
import org.springframework.test.web.reactive.server.WebTestClient


@SpringBootTest
class DemoWebFluxApplicationTests {
	@Test
	fun contextLoads() {
	}
}

//fun main(args: Array<String>){
//	// 라이브 서버 없이 Spring WebFlux에서 테스트하려면 GraphQL HTTP 엔드포인트를 선언하는 Spring 구성을 가리킵니다.
//	// HttpGraphQlTester WebTestClient를 사용하여 구성 방법에 따라 라이브 서버 유무에 관계없이 HTTP를 통해 GraphQL 요청을 실행합니다 WebTestClient.
//
//	val context: ApplicationContext = SpringApplication.run(Application::class.java, *args)
//	val client: WebTestClient = WebTestClient.bindToApplicationContext(context)
//		.configureClient()
//		.baseUrl("/graphql")
//		.build()
//
//	val tester: HttpGraphQlTester = HttpGraphQlTester.create(client)
//}

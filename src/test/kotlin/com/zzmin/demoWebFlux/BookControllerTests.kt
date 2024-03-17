package com.zzmin.demoWebFlux

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.graphql.test.tester.GraphQlTester

@SpringBootTest
class BookControllerTests {
//    @Autowired
//    private lateinit var graphQlTester : GraphQlTester
//
//    @Test
//    fun shouldGetFirstBook() {
//        graphQlTester
//            .documentName("bookDetails")
//            .variable("id", "book-1")
//            .execute()
//            .path("bookById")
//            .matchesJson(
//                """
//                {
//                    "id": "book-1",
//                    "name": "Effective Java",
//                    "pageCount": 416,
//                    "author": {
//                        "firstName": "Joshua",
//                        "lastName": "Bloch"
//                    }
//                }
//                """
//            )
//    }
}
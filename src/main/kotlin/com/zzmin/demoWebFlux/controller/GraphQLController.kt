package com.zzmin.demoWebFlux.controller

import graphql.GraphQL
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class GraphQLController {

//    @Autowired
//    lateinit var graphQL: GraphQL

//    @GetMapping("/graphql")
//    fun graphqlGet(@RequestParam("query") query: String): Map<String, Any> {
//        val executionResult = graphQL.execute(query)
//        return executionResult.toSpecification()
//    }

//    @PostMapping("/graphql")
//    fun graphql(@RequestBody request: Map<String, String>): Map<String, Any> {
//        val query: String? = request["query"]
//        val executionResult = graphQL.execute(query)
//        return executionResult.toSpecification()
//    }


}
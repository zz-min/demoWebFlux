package com.zzmin.demoWebFlux.config

import graphql.GraphQL
import graphql.schema.DataFetcher
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.io.InputStreamReader

@Component
class GraphQLConfig {
//    @Bean
//    fun graphQL(): GraphQL {
//        val schemaParser = SchemaParser()
//        val schemaInputStream = javaClass.getResourceAsStream("/graphql/schema.graphqls")
//        val schemaReader = InputStreamReader(schemaInputStream)
//        val typeRegistry = schemaParser.parse(schemaReader)
//
//        val runtimeWiring = RuntimeWiring.newRuntimeWiring()
//            .type("Query") { typeWiring ->
//                typeWiring.dataFetcher("hello", DataFetcher<String> { environment -> "Hello, GraphQL!" })
//            }
//            .build()
//        //  Query 타입의 hello 필드에 대한 데이터 페처(DataFetcher)를 설정하고 있습니다.
//        //  이 필드에 대한 데이터 페처는 환경(Environment)을 입력으로 받아 "Hello, GraphQL!" 문자열을 반환합니다.
//
//
//        val schemaGenerator = SchemaGenerator()
//        val graphQLSchema = schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring)
//        return GraphQL.newGraphQL(graphQLSchema).build()
//    }
}
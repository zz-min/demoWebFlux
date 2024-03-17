package com.zzmin.demoWebFlux.config

import com.mongodb.reactivestreams.client.MongoClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.convert.TypeMapper
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.core.convert.MappingMongoConverter

@Configuration
class MongoConfig {
    @Bean
    fun reactiveMongoTemplate(mongoClient: MongoClient): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(mongoClient, "zzminDB")
    }
}

//@Configuration
//class MongoConfig(@Autowired val mongoClient: MongoClient) {
//    @Bean
//    fun reactiveMongoTemplate(): ReactiveMongoTemplate {
//        return ReactiveMongoTemplate(mongoClient, "zzminDB")
//    }
//    @Bean
//    fun reactiveMongoTemplate(): ReactiveMongoTemplate {
//        val mongoClient = com.mongodb.reactivestreams.client.MongoClients.create()
//        val mongoDatabaseFactory = SimpleReactiveMongoDatabaseFactory(mongoClient, "zzminDB")
//        val converter = MappingMongoConverter(mongoDatabaseFactory, TypeMapper.DEFAULT)
//
//        return ReactiveMongoTemplate(mongoDatabaseFactory)
//    }
//}
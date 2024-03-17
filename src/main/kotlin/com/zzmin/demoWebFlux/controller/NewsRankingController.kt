package com.zzmin.demoWebFlux.controller

import com.zzmin.demoWebFlux.data.Book
import com.zzmin.demoWebFlux.data.NewsRanking
import com.zzmin.demoWebFlux.service.NewsRankingService
import com.zzmin.demoWebFlux.service.NewsRankingServiceImpl
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@Controller
class NewsRankingController (private val newsRankingService: NewsRankingServiceImpl) {
    @QueryMapping
    fun todayNewsRanking(): NewsRanking? {
        return newsRankingService.getTodayNewsRankings().blockFirst()
    }

//    fun findById(id: String?): Mono<Account?>? {
//        return template.findById(id!!, Account::class.java)
//    }
//
//    fun findAll(): Flux<Account?>? {
//        return template.findAll(Account::class.java)
//    }
//
//    fun save(account: Mono<Account>?): Mono<Account>? {
//        return template.save(account!!)
//    }
}

//@RestController
//class NewsRankingController(private val reactiveMongoTemplate: ReactiveMongoTemplate) {
//    @PostMapping("/items")
//    fun createItem(@RequestBody item: Item): Mono<Item> {
//        return reactiveMongoTemplate.save(item)
//    }
//
//    @GetMapping("/newsRankings")
//    fun getAllData(): Flux<NewsRanking> {
//        return reactiveMongoTemplate.findAll(NewsRanking::class.java)
//    }
//}
package com.zzmin.demoWebFlux.service

import com.jayway.jsonpath.Criteria
import com.zzmin.demoWebFlux.data.NewsRanking
import com.zzmin.demoWebFlux.util.Logger
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.io.Serial
import java.time.LocalDate

@Service
class NewsRankingServiceImpl(private val reactiveMongoTemplate: ReactiveMongoTemplate) :NewsRankingService {
    override fun test() {
        Logger.info("테스트중입니닷!!")
    }

    override fun registerNewsRanking(newsRanking: NewsRanking) {
        TODO("Not yet implemented")
    }

    override fun getAllNewsRankings(): Flux<NewsRanking> {
        TODO("Not yet implemented")
    }

    override fun getNewsRankingById(id: String): Mono<NewsRanking> {
        TODO("Not yet implemented")
    }

    override fun getNewsRankingsByDate(date: Int): Flux<NewsRanking> {
        TODO("Not yet implemented")
    }

    override fun getTodayNewsRankings(): Flux<NewsRanking> {
        val today = LocalDate.now()
        val startOfDay = today.atStartOfDay()
        val endOfDay = today.atTime(23, 59, 59)

        val query = Query()
            .addCriteria(
                Criteria.where("date").gte(startOfDay).lte(endOfDay)
            )

        return reactiveMongoTemplate.find(query, NewsRanking::class.java)
    }
//    override fun getTodayNewsRankings(): Flux<NewsRanking> {
//        val today = LocalDate.now()
//        val startOfDay = today.atStartOfDay()
//        val endOfDay = today.atTime(23, 59, 59)
//
//        return newsRankingRepository.findByDateBetween(startOfDay, endOfDay)
//    }

    override fun updateNewsRanking(newsId: String, updatedNewsRanking: NewsRanking): Mono<NewsRanking> {
        TODO("Not yet implemented")
    }

    override fun deleteNewsRanking(newsId: String): Mono<Void> {
        TODO("Not yet implemented")
    }

}
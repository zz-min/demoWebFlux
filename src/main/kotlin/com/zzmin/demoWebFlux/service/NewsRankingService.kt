package com.zzmin.demoWebFlux.service

import com.zzmin.demoWebFlux.data.NewsRanking
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface NewsRankingService {
    fun test()

    // 새로운 뉴스 랭킹 등록
    fun registerNewsRanking(newsRanking: NewsRanking)

    // 모든 뉴스 랭킹 조회
    fun getAllNewsRankings(): Flux<NewsRanking>

    // 특정 뉴스 랭킹 조회 - ById
    fun getNewsRankingById(id: String): Mono<NewsRanking>

    // 특정 날짜의 뉴스 랭킹 조회 - ByDate
    fun getNewsRankingsByDate(date: Int): Flux<NewsRanking>

    // 오늘 뉴스 랭킹 조회
    fun getTodayNewsRankings(): Flux<NewsRanking>

    // 뉴스 랭킹 수정
    fun updateNewsRanking(newsId: String, updatedNewsRanking: NewsRanking): Mono<NewsRanking>

    // 뉴스 랭킹 삭제
    fun deleteNewsRanking(newsId: String): Mono<Void>
}
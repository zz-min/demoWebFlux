package com.zzmin.demoWebFlux.data

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class NewsRanking {
    @Id
    private val id: String? = null
    private val date: String? = null
    private val hour: Int? = null
    private val title: String? = null
    private val publisher: String? = null
    private val comments: Comment? = null
}

//@Document
//data class NewsRanking(@Id val id: String? = null, val date: Int, val hour: Int, val title: String, val publisher: String, val comments: List<Map<String, Any>>)

// comments => Map<String, Any> 사용하여 구현
//{
//    "_id": ObjectId("609a6dd18a9e7b73df9a8f92"), // 고유한 아이디
//    "date": 20240317,
//    "hour": 12,
//    "title": "뉴스 기사 제목",
//    "publisher": "뉴스사명",
//    "comments": [
//    {
//        "user": "댓글을 쓴 사용자1",
//        "password": "pw123!",
//        "content": "댓글 내용1",
//        "timestamp": ISODate("2022-05-15T12:05:00Z")
//    },
//    {
//        "user": "댓글을 쓴 사용자2",
//        "password": "pw123!",
//        "content": "댓글 내용2",
//        "timestamp": ISODate("2022-05-15T12:10:00Z")
//    }
//    ]
//}
package com.zzmin.demoWebFlux.data

import java.time.Instant

class Comment{
    private val user: String? = null
    private val password:String? = null
    private val content:String? = null
    private val timestamp:String? = null
}


//data class Comment(val user:String,val password:String, val content:String, val timestamp: Instant = Instant.now()) {}


//{
//    "user": "댓글을 쓴 사용자1",
//    "password": "pw123!",
//    "content": "댓글 내용1",
//    "timestamp": ISODate("2022-05-15T12:05:00Z")
//},
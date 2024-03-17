package com.zzmin.demoWebFlux.controller

import com.zzmin.demoWebFlux.data.Book
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller


@Controller
class BookController {
    @QueryMapping
    fun greeting(): String? {
        return "Hello, World!"
    }

    @QueryMapping
    fun greeting2(@Argument name: String): String? {
        return "Welcome! "+name+" :D"
    }

    @QueryMapping
    fun bookById(@Argument id: String): Book? {
        return Book.getById(id)
    }

//    @SchemaMapping
//    fun author(book: Book): Author? {
//        return Author.getById(book.authorId)
//    }
}


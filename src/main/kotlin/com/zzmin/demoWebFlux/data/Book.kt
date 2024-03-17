package com.zzmin.demoWebFlux.data

data class Book(val id: String, val name: String, val pageCount: Int, val authorId: String) {
    companion object {
        private val books = listOf(
            Book("book-1", "Effective Java", 416, "author-1"),
            Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2"),
            Book("book-3", "Down Under", 436, "author-3")
        )

        fun getById(id: String): Book? {
            return books.firstOrNull { it.id == id }
            // firstOrNull : 주어진 조건을 만족하는 첫 번째 요소를 반환하거나, 요소가 없을 경우 null을 반환
        }
    }
}
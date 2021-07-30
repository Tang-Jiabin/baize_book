package com.baize.book.dao

import com.baize.book.po.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book,Int?>, JpaSpecificationExecutor<Book> {
}
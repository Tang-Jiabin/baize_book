package com.baize.book.service

import com.baize.book.common.BookTypeEnum
import com.baize.book.dao.BookRepository
import com.baize.book.pojo.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import java.util.*
import javax.persistence.criteria.Predicate

@Service
class BookService {

    @Autowired
    private lateinit var bookRepository: BookRepository


//    fun findBookPage(page: Int, size: Int, search: String,type:BookTypeEnum): Page<Book> {
//        val pageable: Pageable = PageRequest.of(page, size, Sort.Direction.DESC, "videoId")
//
//        return bookRepository.findAll({ root, query, criteriaBuilder ->
//            val list: MutableList<Predicate> = ArrayList()
//            if (StringUtils.hasText(search)) {
//                list.add(criteriaBuilder.like(root.get("introduce").`as`(String::class.java), "%$search%"))
//            }
//            val p = arrayOfNulls<Predicate>(list.size)
//            val toTypedArray = list.toTypedArray()
//
//            criteriaBuilder.and()
//        }, pageable)

//    }


}

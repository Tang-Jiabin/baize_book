package com.baize.book.service

import com.baize.book.common.BookTypeEnum
import com.baize.book.dao.BookRepository
import com.baize.book.po.Book
import com.baize.book.utils.DateUtil
import com.baize.book.vo.BookVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils
import org.springframework.util.StringUtils
import java.util.*
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root


@Service
class BookService {

    @Autowired
    private lateinit var bookRepository: BookRepository


    fun findBookPage(page: Int, size: Int, search: String?, type: BookTypeEnum?,properties:String): Page<Book> {
        val pageable: Pageable = PageRequest.of(page, size, Sort.Direction.DESC, properties)
        return bookRepository.findAll({ root, query, criteriaBuilder ->
            val list: MutableList<Predicate> = ArrayList()
            if (StringUtils.hasText(search)) {
                list.add(criteriaBuilder.like(root.get<String>("search"), "%$search%"))
            }
            if (!ObjectUtils.isEmpty(type)) {
                list.add(criteriaBuilder.equal(root.get<BookTypeEnum>("category"),type))
            }
            val p: Array<Predicate> = list.toTypedArray()
            criteriaBuilder.and(*p)
        }, pageable)
    }

    fun bookListPO2VO(bookList: List<Book>): List<BookVO> {
        val bookVOList = ArrayList<BookVO>()
        for (book in bookList) {
            bookVOList.add(bookPO2VO(book))
        }
        return bookVOList
    }

    fun bookPO2VO(book: Book): BookVO {
        val bookVO = BookVO()
        bookVO.bookName = book.bookName
        bookVO.author = book.author
        bookVO.cover = book.cover
        bookVO.category = book.category.alias
        bookVO.introduce = book.introduce
        bookVO.latestChapter = book.latestChapterName
        bookVO.updateTime = book.updateTime?.let { DateUtil.dateFormat(it, "MM-dd") }
        bookVO.link = "/${book.category.type}/${book.bookId}.html"
        return bookVO
    }


}

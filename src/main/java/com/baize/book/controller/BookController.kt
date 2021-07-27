package com.baize.book.controller

import com.baize.book.vo.BookVO
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

/**
 * 书籍
 * @author J.Tang
 * @date 2021/7/15
 * @version 1.0
 */
@Controller
class BookController {


    @GetMapping("/", "/index.html")
    fun indexView(): ModelAndView {
        val mv = ModelAndView("index")
        mv.addObject("domain", "https://domain.com");


        val xuanhuan = ArrayList<BookVO>()
        for (index in 1..10) {
            val book = BookVO()
            book.author = "作者  [$index]"
            book.introduce = "介绍  [$index]"
            book.cover = "https://www.baidu.com/封面"
            book.link = "https://www.baidu.com/封面"
            book.category = "玄幻"
            book.latestChapter = "第一章 章节名称"
            book.updateTime = "3小时前"
            book.bookName = "书名 玄幻 [$index]"
            xuanhuan.add(book);
        }

        mv.addObject("xuanhuan",xuanhuan)

        return mv
    }


    @GetMapping("/search")
    fun search(@RequestParam searches: String): ModelAndView {
        val mv = ModelAndView("search")
        println(searches)
        mv.addObject("s", "searches")
        return mv
    }
}
package com.baize.book.controller

import com.baize.book.common.BookConfig
import com.baize.book.common.BookTypeEnum
import com.baize.book.service.BookService
import com.baize.book.vo.BookVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest

/**
 * 书籍
 * @author J.Tang
 * @date 2021/7/15
 * @version 1.0
 */
@Controller
class BookController {

    @Autowired
    private lateinit var bookService: BookService

    @Autowired
    private lateinit var bookConfig: BookConfig

    @GetMapping("/", "/index.html")
    fun indexView(): ModelAndView {

        val mv = ModelAndView("index")
        mv.addObject("domain", bookConfig.domain);

        val tuijian = bookService.bookListPO2VO(bookService.findBookPage(0, 6, null, null,"readNumber").content)
        mv.addObject("tuijian", tuijian)

        val xuanhuan = bookService.bookListPO2VO(bookService.findBookPage(0, 10, null, BookTypeEnum.XUAN_HUAN,"readNumber").content)
        mv.addObject("xuanhuan", xuanhuan)

        val xianxia = bookService.bookListPO2VO(bookService.findBookPage(0, 10, null, BookTypeEnum.XIAN_XIA,"readNumber").content)
        mv.addObject("xianxia", xianxia)

        val dushi = bookService.bookListPO2VO(bookService.findBookPage(0, 10, null, BookTypeEnum.DU_SHI,"readNumber").content)
        mv.addObject("dushi", dushi)

        val lsshi = bookService.bookListPO2VO(bookService.findBookPage(0, 10, null, BookTypeEnum.LI_SHI,"readNumber").content)
        mv.addObject("lsshi", lsshi)

        val youxi = bookService.bookListPO2VO(bookService.findBookPage(0, 10, null, BookTypeEnum.YOU_XI,"readNumber").content)
        mv.addObject("youxi", youxi)

        val kehuan = bookService.bookListPO2VO(bookService.findBookPage(0, 10, null, BookTypeEnum.KE_HUAN,"readNumber").content)
        mv.addObject("kehuan", kehuan)

        val ruku = bookService.bookListPO2VO(bookService.findBookPage(0, 20, null, null,"addTime").content)
        mv.addObject("ruku",ruku)

        val gengxin = bookService.bookListPO2VO(bookService.findBookPage(0,20,null,null,"updateTime").content)
        mv.addObject("gengxin",gengxin)
        return mv
    }


    @GetMapping("/search", "/search.html")
    fun search(@RequestParam searches: String): ModelAndView {
        val mv = ModelAndView("search")
        val bookPage = bookService.findBookPage(0, 10, "", null,"readNumber")
        val bookVOList = bookService.bookListPO2VO(bookPage.content)
        mv.addObject("bookPage", bookVOList)
        return mv
    }

    @GetMapping("/{type}.html",)
    fun type(@PathVariable("type") type: String): ModelAndView {
        val mv = ModelAndView("search")
        return mv
    }

    @GetMapping("/shuku.html",)
    fun shuku(): ModelAndView {
        val mv = ModelAndView("shuku")
        return mv
    }

    @GetMapping("/paihang.html",)
    fun paihang(): ModelAndView {
        val mv = ModelAndView("paihang")
        return mv
    }

    @GetMapping("/gengxin.html",)
    fun gengxin(): ModelAndView {
        val mv = ModelAndView("gengxin")
        return mv
    }

    @GetMapping("/denglu.html",)
    fun denglu(): ModelAndView {
        val mv = ModelAndView("denglu")
        return mv
    }
    @GetMapping("/zuijin.html",)
    fun zuijin(): ModelAndView {
        val mv = ModelAndView("zuijin")
        return mv
    }

    @GetMapping("/zuixin.html",)
    fun zuixin(): ModelAndView {
        val mv = ModelAndView("zuixin")
        return mv
    }
}
package com.baize.book.pojo

import com.baize.book.common.BookTypeEnum
import lombok.Data
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "baize_book")
class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var bookId: Int = 0

    /**
     * 书名
     */
    var bookName: String = "未知"

    /**
     * 作者
     */
    var author: String = "未知"

    /**
     * 封面
     */
    var cover: String? = null

    /**
     * 类别
     */
    var category: BookTypeEnum = BookTypeEnum.QI_TA

    /**
     * 介绍
     */
    var introduce: String = "暂无介绍"

    /**
     * 最新章节
     */
    var latestChapter: String? = null

    /**
     * 更新时间
     */
    var updateTime: LocalDateTime? = LocalDateTime.now()

    /**
     * 上架日期
     */
    var addTime: LocalDateTime? = null
}
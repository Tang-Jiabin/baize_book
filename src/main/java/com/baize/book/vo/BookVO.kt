package com.baize.book.vo

import lombok.Data

/**
 * 书籍VO
 *
 * @author J.Tang
 * @version 1.0
 * @date 2021/7/27
 */

class BookVO {
    /**
     * 书名
     */
    var bookName: String? = null

    /**
     * 作者
     */
    var author: String? = null

    /**
     * 封面
     */
    var cover: String? = null

    /**
     * 类别
     */
    var category: String? = null

    /**
     * 介绍
     */
    var introduce: String? = null

    /**
     * 最新章节
     */
    var latestChapter: String? = null

    /**
     * 更新时间
     */
    var updateTime: String? = null

    /**
     * 链接
     */
    var link: String? = null
}
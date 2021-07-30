package com.baize.book.common


import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "book")
class BookConfig {
     var domain: String? = null
}
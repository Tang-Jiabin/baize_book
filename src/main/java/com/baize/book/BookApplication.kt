package com.baize.book

import org.apache.catalina.Context
import org.apache.tomcat.util.http.LegacyCookieProcessor
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.context.annotation.Bean

/**
 * @author J.Tang
 * @date 2021/7/15
 * @version 1.0
 */
@SpringBootApplication
open class BookApplication{
    //Tomcat8 Cookie 解析向下兼容
    @Bean
    open fun cookieProcessorCustomizer(): WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
        return WebServerFactoryCustomizer() { factory: TomcatServletWebServerFactory ->
            factory.addContextCustomizers(TomcatContextCustomizer() { context: Context ->
                context.cookieProcessor = LegacyCookieProcessor()
            })
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(BookApplication::class.java, *args)
}
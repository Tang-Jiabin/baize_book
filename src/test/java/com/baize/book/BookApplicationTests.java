package com.baize.book;
import com.baize.book.common.BookTypeEnum;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.baize.book.dao.BookRepository;
import com.baize.book.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void contextLoads() {
        List<Book> all = bookRepository.findAll();
        for (Book book : all) {
            switch(Objects.requireNonNull(book.getCategory())){
                case QI_TA -> System.out.println("qt");
                case LI_SHI -> System.out.println("");
                case XIAN_SHI -> System.out.println("xs");
            }
        }
    }

}

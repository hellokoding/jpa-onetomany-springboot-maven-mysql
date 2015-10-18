package com.hellokoding.jpa;

import com.hellokoding.jpa.model.Book;
import com.hellokoding.jpa.model.BookCategory;
import com.hellokoding.jpa.repository.BookCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.HashSet;

@SpringBootApplication
public class HelloJpaApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(HelloJpaApplication.class);

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelloJpaApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        // save a couple of categories
        BookCategory categoryA = new BookCategory("Category A", new HashSet<Book>(){{
            add(new Book("Book A1"));
            add(new Book("Book A2"));
            add(new Book("Book A3"));
        }});

        BookCategory categoryB = new BookCategory("Category B", new HashSet<Book>(){{
            add(new Book("Book B1"));
            add(new Book("Book B2"));
            add(new Book("Book B3"));
        }});

        bookCategoryRepository.save(new HashSet<BookCategory>() {{
            add(categoryA);
            add(categoryB);
        }});

        // fetch all categories
        for (BookCategory bookCategory : bookCategoryRepository.findAll()) {
            logger.info(bookCategory.toString());
        }
    }
}

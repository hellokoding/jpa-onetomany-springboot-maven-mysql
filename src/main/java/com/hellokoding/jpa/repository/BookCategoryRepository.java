package com.hellokoding.jpa.repository;

import com.hellokoding.jpa.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer>{
}

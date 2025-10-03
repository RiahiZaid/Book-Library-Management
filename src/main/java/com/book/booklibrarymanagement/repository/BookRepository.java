package com.book.booklibrarymanagement.repository;


import com.book.booklibrarymanagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}

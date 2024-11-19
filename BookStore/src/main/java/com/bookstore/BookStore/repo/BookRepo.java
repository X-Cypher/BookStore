package com.bookstore.BookStore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.BookStore.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}

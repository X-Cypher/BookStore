package com.bookstore.BookStore.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.BookStore.entity.MyBookList;

@Repository
public interface MyBooksRepo extends JpaRepository<MyBookList, Integer> {

}

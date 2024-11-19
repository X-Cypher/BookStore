package com.bookstore.BookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.BookStore.entity.MyBookList;
import com.bookstore.BookStore.repo.MyBooksRepo;

@Service
public class MyBooksListService {

    @Autowired
    private MyBooksRepo repo;

    public void saveMyBooks(MyBookList book){
        repo.save(book);
    }

    public List<MyBookList> getAllMyBooks(){
        return repo.findAll();
    }

    public void deleteById(Integer id){
        repo.deleteById(id);
    }
}

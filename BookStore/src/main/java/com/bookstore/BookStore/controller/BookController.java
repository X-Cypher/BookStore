package com.bookstore.BookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.BookStore.entity.Book;
import com.bookstore.BookStore.entity.MyBookList;
import com.bookstore.BookStore.service.BookService;
import com.bookstore.BookStore.service.MyBooksListService;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller       
@RequestMapping("/")            
public class BookController {
    
    @Autowired
    private BookService service;

    @Autowired
    private MyBooksListService myBookService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/register_book")
    public String registerBook(){
        return "registerBook";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List<Book> list = service.getAllBooks();

        return new ModelAndView("bookList", "book", list);
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookList> list = myBookService.getAllMyBooks();
        model.addAttribute("book", list);
        return "myBooks";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        service.save(b);
        return "redirect:/available_books";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") Integer id){
        Book b = service.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Integer id, Model model){
        Book b = service.getBookById(id);
        model.addAttribute("book", b);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String requestMethodName(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/available_books";
    }    
}

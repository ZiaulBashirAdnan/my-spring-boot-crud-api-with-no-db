package com.mycrudAPIwithNOdb.crud.controller;

import com.mycrudAPIwithNOdb.crud.dto.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/books")
public class BookController
{
    List<Book> bookList = new ArrayList<>();
    Integer Id=0;
    @GetMapping
    public List<Book> getBooks()
    {
        return bookList;
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id)
    {
        return bookList.get(id-1);
    }
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book)
    {
        book.setId(++Id);
        bookList.add(book);
        return book;
    }

    @PutMapping("/update/{id}")
    public Book addBook(@PathVariable Integer id,  @RequestBody Book book)
    {
    for(int i=0;i<bookList.size();i++){
        if(bookList.get(i).getId().equals(id)){
            book.setId(id);
          bookList.set(i,book);
          break;
         }
    }
        return book;
    }

    @DeleteMapping("/delete")
    public void deleteBook(@RequestParam Integer id)
    {
     bookList.removeIf(book -> Objects.equals(book.getId(),id));
    }

}

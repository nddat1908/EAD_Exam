package com.example.nguyendacdat.service;

import com.example.nguyendacdat.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<BookEntity> getAll(String namebook);
    BookEntity createBook(BookEntity b);


}

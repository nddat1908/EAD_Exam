package com.example.nguyendacdat.service;

import com.example.nguyendacdat.entity.BookEntity;
import com.example.nguyendacdat.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepo bookRepo;


    @Override
    public List<BookEntity> getAll(String namebook) {
        if (namebook != null) {
            return bookRepo.search(namebook);
        }
        return bookRepo.findAll();
    }

    @Override
    public BookEntity createBook(BookEntity b) {
        return bookRepo.save(b);
    }
}

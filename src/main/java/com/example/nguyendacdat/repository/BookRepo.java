package com.example.nguyendacdat.repository;

import com.example.nguyendacdat.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<BookEntity,Integer> {
    @Query("SELECT b FROM BookEntity b WHERE CONCAT(b.name,'') LIKE %?1%")
    public List<BookEntity> search(String keyword);
//    @Query("SELECT b FROM BookEntity b WHERE b.name LIKE %:keyword%")
//    List<BookEntity> search(String keyword);

}

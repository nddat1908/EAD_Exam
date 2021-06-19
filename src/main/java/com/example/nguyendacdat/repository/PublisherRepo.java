package com.example.nguyendacdat.repository;

import com.example.nguyendacdat.entity.BookEntity;
import com.example.nguyendacdat.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublisherRepo extends JpaRepository<PublisherEntity,Integer> {
    @Query("SELECT p FROM PublisherEntity p WHERE CONCAT(p.name,'') LIKE %?1%")
    public List<PublisherEntity> search(String keyword);
}

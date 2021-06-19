package com.example.nguyendacdat.service;

import com.example.nguyendacdat.entity.PublisherEntity;
import com.example.nguyendacdat.repository.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    PublisherRepo publisherRepo;


    @Override
    public List<PublisherEntity> getAllPublisher(String namepublisher) {
        if (namepublisher != null) {
            return publisherRepo.search(namepublisher);
        }
        return publisherRepo.findAll();
    }

    @Override
    public PublisherEntity createPublisher(PublisherEntity p) {
        return publisherRepo.save(p);
    }
}

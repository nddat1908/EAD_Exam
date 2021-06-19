package com.example.nguyendacdat.service;

import com.example.nguyendacdat.entity.PublisherEntity;

import java.util.List;

public interface PublisherService {
    List<PublisherEntity> getAllPublisher(String namepublisher);
    PublisherEntity createPublisher(PublisherEntity p);
}

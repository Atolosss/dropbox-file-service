package com.example.dropboxsfileservice.repository;

import com.example.dropboxsfileservice.model.FileMetaData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FileMetaDataRepository extends MongoRepository<FileMetaData, String> {
    List<FileMetaData> findByUserId(Long id);
}

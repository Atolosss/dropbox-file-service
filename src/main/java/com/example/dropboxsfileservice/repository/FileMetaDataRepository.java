package com.example.dropboxsfileservice.repository;

import com.example.dropboxsfileservice.model.FileMetaData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileMetaDataRepository extends MongoRepository<FileMetaData, String> {

}

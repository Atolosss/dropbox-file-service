package com.example.dropboxsfileservice.repository;

import com.example.dropboxsfileservice.model.FileBinaryData;
import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FileBinaryDataRepository extends MongoRepository<FileBinaryData, String> {
    Optional<FileBinaryData> findFileBinaryDataByFileData(Binary fileData);
}

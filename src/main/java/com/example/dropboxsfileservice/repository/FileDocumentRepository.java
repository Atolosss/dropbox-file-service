package com.example.dropboxsfileservice.repository;

import com.example.dropboxsfileservice.model.FileDocument;
import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FileDocumentRepository extends MongoRepository<FileDocument, String> {
    Optional<FileDocument> findFileDocumentByFileData(Binary fileData);
}

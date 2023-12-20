package com.example.dropboxs3service.repository;

import com.example.dropboxs3service.model.FileDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileDocumentRepository extends MongoRepository<FileDocument, String> {
}

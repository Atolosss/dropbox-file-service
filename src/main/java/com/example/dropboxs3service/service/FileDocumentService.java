package com.example.dropboxs3service.service;

import com.example.dropboxs3service.model.FileDocument;
import com.example.dropboxs3service.repository.FileDocumentRepository;
import lombok.AllArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class FileDocumentService {

    @Autowired
    private FileDocumentRepository fileDocumentRepository;
//создать exception на проверку имени
    public String addFile(final String title, final MultipartFile file) throws IOException {
        FileDocument document = new FileDocument(title);
        document.setFileData(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        document = fileDocumentRepository.insert(document);
        return document.getId();
    }

    public FileDocument getFile(final String id) {
        return fileDocumentRepository.findById(id).orElseThrow();
    }

}

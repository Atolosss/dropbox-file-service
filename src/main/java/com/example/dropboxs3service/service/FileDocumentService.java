package com.example.dropboxs3service.service;

import com.example.dropboxs3service.model.FileDocument;
import com.example.dropboxs3service.model.dto.UploadFileDto;
import com.example.dropboxs3service.model.dto.UploadFileRs;
import com.example.dropboxs3service.repository.FileDocumentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@AllArgsConstructor
@Slf4j
public class FileDocumentService {

    private final FileDocumentRepository fileDocumentRepository;

    public UploadFileRs uploadFile(final UploadFileDto uploadFileDto) {
        final byte[] decoded = Base64.getDecoder().decode(uploadFileDto.getBase64Data());

        final FileDocument document = FileDocument.builder()
                .name(uploadFileDto.getName())
                .fileData(new Binary(BsonBinarySubType.BINARY, decoded))
                .build();

        fileDocumentRepository.save(document);

        return UploadFileRs.builder()
                .key(document.getId())
                .build();
    }

    public FileDocument findFileById(final String id) {
        return fileDocumentRepository.findById(id)
                .orElseThrow();
    }

}

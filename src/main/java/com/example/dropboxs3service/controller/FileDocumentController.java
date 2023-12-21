package com.example.dropboxs3service.controller;

import com.example.dropboxs3service.model.FileDocument;
import com.example.dropboxs3service.model.dto.UploadFileDto;
import com.example.dropboxs3service.model.dto.UploadFileRs;
import com.example.dropboxs3service.service.FileDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FileDocumentController {

    private final FileDocumentService fileDocumentService;

    //TODO: дедупликацмя файлов
    //TODO: Хранить хэшированное значение base64 файла (для ускорения поиска)
    @PostMapping(value = "/files")
    public UploadFileRs uploadFile(@RequestBody final UploadFileDto uploadFileDto) {
        return fileDocumentService.uploadFile(uploadFileDto);
    }

    //TODO: получение файла по id из dropbox
    //TODO: rename dropbox -> dropbox-api-service
    //TODO: rename dropbox-s3-service -> dropbox-storage-service
    //TODO: move to open api
    //TODO: tests
    //TODO: refactor tests (поднять покрытие по jacoco)

    @GetMapping("/files/{id}")
    public FileDocument getFile(@PathVariable String id) {
        return fileDocumentService.findFileById(id);
    }

}

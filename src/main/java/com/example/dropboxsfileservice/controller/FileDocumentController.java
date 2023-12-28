package com.example.dropboxsfileservice.controller;

import com.example.dropboxsfileservice.service.FileDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gmm.demo.controller.api.FileApi;
import ru.gmm.demo.model.api.UploadFileDto;
import ru.gmm.demo.model.api.UploadFileRs;


//TODO: tests
//TODO: refactor tests (поднять покрытие по jacoco)
@RestController
@RequiredArgsConstructor
public class FileDocumentController implements FileApi {

    private final FileDocumentService fileDocumentService;

    @Override
    public ResponseEntity<UploadFileRs> postFile(final UploadFileDto uploadFileDto) {
        return ResponseEntity.ok(fileDocumentService.uploadFile(uploadFileDto));
    }

}

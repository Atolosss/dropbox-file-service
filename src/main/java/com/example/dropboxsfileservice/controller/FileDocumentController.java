package com.example.dropboxsfileservice.controller;

import com.example.dropboxsfileservice.service.FileDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gmm.demo.controller.api.FileApi;
import ru.gmm.demo.model.api.UploadFileDto;
import ru.gmm.demo.model.api.UploadFileDtoRq;
import ru.gmm.demo.model.api.UploadFileRs;

@RestController
@RequiredArgsConstructor
public class FileDocumentController implements FileApi {

    private final FileDocumentService fileDocumentService;

    @Override
    public ResponseEntity<UploadFileRs> postFile(@RequestBody final UploadFileDto uploadFileDto) {
        return ResponseEntity.ok(fileDocumentService.uploadFile(uploadFileDto));
    }

    //TODO: tests
    //TODO: refactor tests (поднять покрытие по jacoco)

    @Override
    public ResponseEntity<UploadFileDtoRq> getFile(@PathVariable final String id) {
        return ResponseEntity.ok(fileDocumentService.findFileById(id));
    }

}

package com.example.dropboxsfileservice.controller;

import com.dropbox.controller.api.FileApi;
import com.dropbox.model.api.UploadFileDto;
import com.dropbox.model.api.UploadFileRs;
import com.example.dropboxsfileservice.service.FileDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileDocumentController implements FileApi {

    private final FileDocumentService fileDocumentService;

    @Override
    public ResponseEntity<UploadFileRs> postFile(final UploadFileDto uploadFileDto) {
        return ResponseEntity.ok(fileDocumentService.uploadFile(uploadFileDto));
    }

}

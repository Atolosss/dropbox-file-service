package com.example.dropboxsfileservice.controller;

import com.example.dropboxsfileservice.service.FileDocumentService;
import lombok.RequiredArgsConstructor;
import org.bson.types.Binary;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
@RequiredArgsConstructor
public class IOController {

    private final FileDocumentService fileDocumentService;

    @GetMapping("/api/v1/files/{id}")
    public ResponseEntity<StreamingResponseBody> getFile(@PathVariable final String id) {
        Binary binary = fileDocumentService.findFileById(id);
        StreamingResponseBody body = outputStream -> FileCopyUtils.copy(binary.getData(), outputStream);
        return ResponseEntity.ok()
                .body(body);
    }

}

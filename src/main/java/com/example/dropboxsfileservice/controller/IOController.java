package com.example.dropboxsfileservice.controller;

import com.example.dropboxsfileservice.model.dto.FileMetaRs;
import com.example.dropboxsfileservice.service.FileDocumentService;
import lombok.RequiredArgsConstructor;
import org.bson.types.Binary;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.List;


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

    @GetMapping("/api/v1/files/binary/{id}")
    public ResponseEntity<StreamingResponseBody> getBinaryFiles(@PathVariable final Long id) {
        List<Binary> files = fileDocumentService.getAllFiles(id);
        StreamingResponseBody body = outputStream -> {
            for (Binary file : files) {
                FileCopyUtils.copy(file.getData(), outputStream);
            }
        };
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(body);
    }

    @GetMapping("/api/v1/files/meta/{id}")
    public ResponseEntity<List<FileMetaRs>> getMetaFiles(@PathVariable final Long id) {
        List<FileMetaRs> metaList = fileDocumentService.getAllMetaFiles(id);

        return ResponseEntity.ok(metaList);
    }

}

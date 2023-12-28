package com.example.dropboxsfileservice.service;

import com.example.dropboxsfileservice.constant.ErrorCode;
import com.example.dropboxsfileservice.exception.ServiceException;
import com.example.dropboxsfileservice.mapper.FileMapper;
import com.example.dropboxsfileservice.model.FileDocument;
import com.example.dropboxsfileservice.repository.FileDocumentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import ru.gmm.demo.model.api.UploadFileDto;
import ru.gmm.demo.model.api.UploadFileDtoRq;
import ru.gmm.demo.model.api.UploadFileRs;

import java.util.Base64;

@Service
@AllArgsConstructor
@Slf4j
public class FileDocumentService {

    private final FileDocumentRepository fileDocumentRepository;
    private final FileMapper fileMapper;

    public UploadFileRs uploadFile(final UploadFileDto uploadFileDto) {
        final byte[] decoded = Base64.getDecoder().decode(uploadFileDto.getBase64Data());

        final FileDocument document = FileDocument.builder()
                .name(uploadFileDto.getName())
                .fileData(new Binary(BsonBinarySubType.BINARY, decoded))
                .build();
        if (fileDocumentRepository.findFileDocumentByFileData(document.getFileData()).isEmpty()) {

            fileDocumentRepository.save(document);
            return fileMapper.toUploadFileRs(document);
        }

        return fileMapper.toUploadFileRs(fileDocumentRepository.findFileDocumentByFileData(document.getFileData()).orElseThrow());
    }

    public UploadFileDtoRq findFileById(final String id) {
        FileDocument fileDocument = fileDocumentRepository.findById(id)
                .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_001, id));

        return new UploadFileDtoRq(fileDocument.getFileData().getData());

    }

}

package com.example.dropboxsfileservice.service;

import com.dropbox.model.api.UploadFileDto;
import com.dropbox.model.api.UploadFileRs;
import com.example.dropboxsfileservice.constant.ErrorCode;
import com.example.dropboxsfileservice.exception.ServiceException;
import com.example.dropboxsfileservice.mapper.FileMapper;
import com.example.dropboxsfileservice.model.FileBinaryData;
import com.example.dropboxsfileservice.model.FileMetaData;
import com.example.dropboxsfileservice.model.dto.FileMetaRs;
import com.example.dropboxsfileservice.repository.FileBinaryDataRepository;
import com.example.dropboxsfileservice.repository.FileMetaDataRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class FileDocumentService {

    private final FileBinaryDataRepository fileBinaryDataRepository;
    private final FileMetaDataRepository fileMetaDataRepository;
    private final FileMapper fileMapper;

    public UploadFileRs uploadFile(final UploadFileDto uploadFileDto) {
        final byte[] decoded = Base64.getDecoder().decode(uploadFileDto.getBase64Data());
        final Binary binary = new Binary(BsonBinarySubType.BINARY, decoded);

        final FileBinaryData fileBinaryData = fileBinaryDataRepository.findFileBinaryDataByFileData(binary)
                .orElseGet(() -> fileBinaryDataRepository.save(FileBinaryData.builder()
                        .fileData(binary)
                        .build()));

        final FileMetaData fileMetaData = FileMetaData.builder()
                .name(uploadFileDto.getName())
                .fileBinaryDataId(fileBinaryData.getId())
                .userId(uploadFileDto.getUserId())
                .build();

        fileMetaDataRepository.save(fileMetaData);

        return fileMapper.toUploadFileRs(fileBinaryData);
    }

    public Binary findFileById(final String id) {
        FileBinaryData fileBinaryData = fileBinaryDataRepository.findById(id)
                .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_001, id));

        return fileBinaryData.getFileData();
    }

    public List<Binary> getAllFiles(final Long id) {
        List<FileMetaData> fileMetaData = fileMetaDataRepository.findByUserId(id)
                .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_002, id));
        if (fileMetaData.isEmpty()) {
            throw new ServiceException(ErrorCode.ERR_CODE_002, id);
        }
        List<Binary> binaryList = new ArrayList<>();
        for (FileMetaData f : fileMetaData) {
            binaryList.add(fileBinaryDataRepository.findById(f.getFileBinaryDataId()).get().getFileData());
        }
        return binaryList;
    }

    public List<FileMetaRs> getAllMetaFiles(final Long id) {
        List<FileMetaData> fileMetaData = fileMetaDataRepository.findByUserId(id)
                .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_002, id));
        if (fileMetaData.isEmpty()) {
            throw new ServiceException(ErrorCode.ERR_CODE_002, id);
        }
        return fileMetaData.stream().map(fileMapper::toFileMetaRs).toList();
    }
}

package com.example.dropboxsfileservice.mapper.impl;

import com.dropbox.model.api.UploadFileRs;
import com.example.dropboxsfileservice.mapper.FileMapper;
import com.example.dropboxsfileservice.model.FileBinaryData;
import com.example.dropboxsfileservice.model.FileMetaData;
import com.example.dropboxsfileservice.model.dto.FileMetaRs;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-11T03:01:17+0300",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 19.0.2 (Eclipse Adoptium)"
)
@Component
public class FileMapperImpl implements FileMapper {

    @Override
    public UploadFileRs toUploadFileRs(FileBinaryData fileBinaryData) {
        if ( fileBinaryData == null ) {
            return null;
        }

        UploadFileRs uploadFileRs = new UploadFileRs();

        uploadFileRs.setKey( fileBinaryData.getId() );

        return uploadFileRs;
    }

    @Override
    public FileMetaRs toFileMetaRs(FileMetaData fileMetaData) {
        if ( fileMetaData == null ) {
            return null;
        }

        FileMetaRs fileMetaRs = new FileMetaRs();

        fileMetaRs.setName( fileMetaData.getName() );

        return fileMetaRs;
    }
}

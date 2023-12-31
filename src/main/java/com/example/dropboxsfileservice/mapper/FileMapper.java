package com.example.dropboxsfileservice.mapper;

import com.example.dropboxsfileservice.model.FileBinaryData;
import com.example.dropboxsfileservice.model.FileMetaData;
import com.example.dropboxsfileservice.model.dto.FileMetaRs;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gmm.demo.model.api.UploadFileRs;

@Mapper(config = MapperConfiguration.class)
public interface FileMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "key", source = "id")
    UploadFileRs toUploadFileRs(FileBinaryData fileBinaryData);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    FileMetaRs toFileMetaRs(FileMetaData fileMetaData);

}

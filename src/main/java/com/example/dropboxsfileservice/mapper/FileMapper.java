package com.example.dropboxsfileservice.mapper;

import com.dropbox.model.api.UploadFileRs;
import com.example.dropboxsfileservice.model.FileBinaryData;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface FileMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "key", source = "id")
    UploadFileRs toUploadFileRs(FileBinaryData fileBinaryData);

}

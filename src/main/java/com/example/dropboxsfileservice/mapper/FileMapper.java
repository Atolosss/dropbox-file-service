package com.example.dropboxsfileservice.mapper;

import com.example.dropboxsfileservice.model.FileDocument;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gmm.demo.model.api.UploadFileRs;

@Mapper(config = MapperConfiguration.class)
public interface FileMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "key", source = "id")
    UploadFileRs toUploadFileRs(FileDocument fileDocument);

}

package com.example.dropboxsfileservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document
public class FileMetaData {
    @Id
    private String id;
    private String name;
    private String fileBinaryDataId;
    private Long userId;

}

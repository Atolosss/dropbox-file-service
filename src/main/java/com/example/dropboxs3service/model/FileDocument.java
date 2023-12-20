package com.example.dropboxs3service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document
public class FileDocument {
    @Id
    private String id;
    private String name;
    private String url;
    private Binary fileData;

    public FileDocument(String name) {
        this.name = name;
    }
}

package com.example.dropboxsfileservice.controller;

import com.example.dropboxsfileservice.model.FileBinaryData;
import com.example.dropboxsfileservice.support.DataProvider;
import com.example.dropboxsfileservice.support.IntegrationTestBase;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.junit.jupiter.api.Test;
import ru.gmm.demo.model.api.UploadFileDto;
import ru.gmm.demo.model.api.UploadFileRs;

import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

public class FileBinaryDataControllerTest extends IntegrationTestBase {

    @Test
    void postFileShouldWork() {
        final UploadFileDto upload = DataProvider.prepareFile().build();

        final Binary binary = new Binary(BsonBinarySubType.BINARY, Base64.getDecoder().decode(upload.getBase64Data()));

        assertThat(postFile(upload))
                .isNotNull();
        assertThat(fileBinaryDataRepository.findFileBinaryDataByFileData(binary).get())
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(FileBinaryData.builder()
                        .fileData(binary)
                        .build());

    }

    private UploadFileRs postFile(final UploadFileDto upload) {
        return webTestClient.post()
                .uri(uriBuilder -> uriBuilder
                        .pathSegment("api", "v1", "files")
                        .build())
                .bodyValue(upload)
                .exchange()
                .expectStatus().isEqualTo(200)
                .expectBody(UploadFileRs.class)
                .returnResult()
                .getResponseBody();
    }

}

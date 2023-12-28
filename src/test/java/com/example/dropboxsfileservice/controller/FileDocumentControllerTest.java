package com.example.dropboxsfileservice.controller;

import com.example.dropboxsfileservice.model.FileDocument;
import com.example.dropboxsfileservice.support.DataProvider;
import com.example.dropboxsfileservice.support.IntegrationTestBase;
import org.junit.jupiter.api.Test;
import ru.gmm.demo.model.api.UploadFileDto;
import ru.gmm.demo.model.api.UploadFileRs;

import static org.assertj.core.api.Assertions.assertThat;

public class FileDocumentControllerTest extends IntegrationTestBase {

    @Test
    void postFileShouldWork() {
        final UploadFileDto upload = DataProvider.prepareFile().build();

        assertThat(postFile(upload))
                .isNotNull();
        assertThat(fileDocumentRepository.findAll())
                .hasSize(1)
                .first()
                .usingRecursiveComparison()
                .ignoringFields("id", "fileData")
                .isEqualTo(FileDocument.builder()
                        .name("123")
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

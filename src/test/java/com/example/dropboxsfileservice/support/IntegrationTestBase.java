package com.example.dropboxsfileservice.support;

import com.example.dropboxsfileservice.repository.FileBinaryDataRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IntegrationTestBase extends MongoDatabaseAwareTestBase {
    @LocalServerPort
    protected int localPort;
    @Autowired
    protected WebTestClient webTestClient;
    @Autowired
    protected FileBinaryDataRepository fileBinaryDataRepository;

    @BeforeEach
    void beforeEach() {
        webTestClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + localPort)
                .build();
    }

    @AfterEach
    void afterEach() {
        fileBinaryDataRepository.deleteAll();
    }

    @Override
    protected Map<String, String> getCollectionsName() {
        Map<String, String> collections = new HashMap<>();
        collections.put("files", "test");
        return collections;
    }

    @Override
    protected Set<String> getCollections() {
        return Set.of("files");
    }

}

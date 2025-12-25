package com.example.mcp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class MigrationHelperService {


    // This looks for the file in src/main/resources
    @Value("classpath:Spring-Boot-4.0-Migration-Guide.asciidoc")
    private Resource wikiResource;

    @Autowired
    private RestClient restClient;

    public String getMigrationGuide() {
        return restClient.get()
                .uri("/wiki/spring-projects/spring-boot/Spring-Boot-4.0-Migration-Guide.md")
                .accept(MediaType.TEXT_PLAIN) // Request plain text
                .retrieve()
                .onStatus(status -> status.is4xxClientError(), (request, response) -> {
                    throw new RuntimeException("Wiki page not found or private");
                })
                .body(String.class);
    }

    public String readWikiFile() throws IOException {
        return wikiResource.getContentAsString(StandardCharsets.UTF_8);
    }
}

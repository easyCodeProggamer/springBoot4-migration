package com.example.mcp.controller;

import com.example.mcp.service.MigrationHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SpringMigrationGuideController {

    @Autowired
    private MigrationHelperService migrationHelperService;

    @GetMapping("/getSpringBoot4MigrationGuide")
    public String getSpringBoot4MigrationGuide (){
        return migrationHelperService.getMigrationGuide();
    }

    @GetMapping("/getSpringBoot4MigrationGuideLocal")
    public String getSpringBoot4MigrationGuideFromLocal () throws IOException {
        return migrationHelperService.readWikiFile();
    }
}


package com.example.mcp.tools;


import com.example.mcp.service.MigrationHelperService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class SpringBoot4MigrationTool {

    private final MigrationHelperService migrationHelperService;

    public SpringBoot4MigrationTool(MigrationHelperService migrationHelperService){
        this.migrationHelperService = migrationHelperService;
    }

    @Tool(
        name = "mrigank_springboot4_migration_guide",
        description = "returns springBoot 4 migration documentation"
    )
    public String getMigrationGuide() throws IOException {
        return migrationHelperService.readWikiFile();
    }
}

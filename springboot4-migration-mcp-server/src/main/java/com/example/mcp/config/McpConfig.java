
package com.example.mcp.config;

import com.example.mcp.service.MigrationHelperService;
import com.example.mcp.tools.SpringBoot4MigrationTool;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class McpConfig {


    @Bean
    ToolCallbackProvider toolCallbackProvider(MigrationHelperService migrationHelperService){
        return MethodToolCallbackProvider.builder().toolObjects(new SpringBoot4MigrationTool(migrationHelperService)).build();

    }
    @Bean
    public RestClient myRestClient(){
        return RestClient
                .builder()
                .baseUrl("https://raw.githubusercontent.com")
                .build()
                ;
    }
}

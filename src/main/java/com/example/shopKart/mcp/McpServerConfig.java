package com.example.shopKart.mcp;


import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.*;

import com.example.shopKart.agent.ShopKartTools;

@Configuration
public class McpServerConfig {

	@Bean
	public ToolCallbackProvider shopKartToolProvider(ShopKartTools shopKartTools) {
		return MethodToolCallbackProvider.builder().toolObjects(shopKartTools).build();
	}
}
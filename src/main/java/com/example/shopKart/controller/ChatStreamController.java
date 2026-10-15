package com.example.shopKart.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/chat")
public class ChatStreamController {

	private final ChatClient chatClient;

	public ChatStreamController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> stream(@RequestParam String message) {
		return chatClient.prompt().user(message).stream().content(); // Flux<String> - one emission per token chunk
	}
}
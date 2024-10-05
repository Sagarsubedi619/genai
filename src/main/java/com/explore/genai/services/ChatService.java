package com.explore.genai.services;

import com.explore.genai.managers.ChatManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatService
{
	@Autowired
	private ChatManager chatManager;

	@GetMapping("/chat")
	String getAnswer(@RequestParam(value = "Prompt") final String prompt)
	{
		if (prompt.isEmpty())
		{
			throw new IllegalArgumentException("Prompt cannot be empty.");
		}
		return chatManager.handlePrompt(prompt);
	}
}

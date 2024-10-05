package com.explore.genai.services;

import com.explore.genai.exceptions.LLMException;
import com.explore.genai.managers.ChatManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatService
{
	@Autowired
	private ChatManager chatManager;

	@RequestMapping("/api/chat")
	String getAnswer(@RequestParam(value = "prompt") final String prompt) throws IllegalArgumentException, LLMException
	{
		if (prompt.isEmpty())
		{
			throw new IllegalArgumentException("Prompt cannot be empty.");
		}
		return chatManager.handlePrompt(prompt);
	}
}

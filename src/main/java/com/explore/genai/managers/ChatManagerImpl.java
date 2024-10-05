package com.explore.genai.managers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatManagerImpl implements ChatManager
{
	@Autowired
	private ChatClient chatClient;

	@Override
	public String handlePrompt(String prompt)
	{
		return chatClient.prompt()
				.user(prompt)
				.call()
				.chatResponse()
				.toString();
	}
}

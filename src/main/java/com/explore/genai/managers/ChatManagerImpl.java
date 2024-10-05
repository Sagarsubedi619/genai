package com.explore.genai.managers;

import com.explore.genai.exceptions.LLMException;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatManagerImpl implements ChatManager
{
	@Autowired
	private OllamaChatModel ollamaChatModel;

	@Override
	public String handlePrompt(String prompt) throws LLMException
	{
		try
		{
			final ChatClient chatClient = ChatClient.builder(ollamaChatModel).build();
			return chatClient.prompt()
					.user(prompt)
					.call()
					.content();
		}
		catch (Exception e)
		{
			throw new LLMException("Processing failed", e);
		}
	}
}

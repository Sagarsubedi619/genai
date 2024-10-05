package com.explore.genai.managers;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatManagerImpl implements ChatManager
{
	@Autowired
	private OllamaChatModel ollamaChatModel;

	@Override
	public String handlePrompt(String prompt)
	{
		return ollamaChatModel.call(prompt);
	}
}

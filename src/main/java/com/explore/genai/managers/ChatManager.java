package com.explore.genai.managers;

import com.explore.genai.exceptions.LLMException;

public interface ChatManager
{
	/**
	 * Returns the generated AI response  for the specified prompt.
	 *
	 * @param prompt
	 * 		The prompt to send to the AI model.
	 * @return The response from the AI model.
	 * @throws LLMException If any exceptions when LLM processing.
	 */
	String handlePrompt(final String prompt) throws LLMException;
}

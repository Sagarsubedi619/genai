package com.explore.genai.managers;

public interface ChatManager
{
	/**
	 * Returns the generated AI response  for the specified prompt.
	 *
	 * @param prompt
	 * 		The prompt to send to the AI model.
	 * @return The response from the AI model.
	 */
	String handlePrompt(final String prompt);
}

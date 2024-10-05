package com.explore.genai.exceptions;

public class LLMException extends Exception
{
	public LLMException(final String message, Throwable e)
	{
		super(message, e);
	}
}

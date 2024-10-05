// Adds a message to the chat box
function addMessage(content, sender)
{
    const chatBox = document.getElementById('chat-box');
    const message = document.createElement('div');
    message.classList.add('chat-message', sender);
    message.textContent = content;
    chatBox.appendChild(message);
    chatBox.scrollTop = chatBox.scrollHeight;  // Scroll to the bottom
}

// Sends a message to the API
async function sendMessage()
{
    const userInput = document.getElementById('user-input');
    const message = userInput.value.trim();

    if (!message) return;

    addMessage(message, 'user');

    document.getElementById('send-button').disabled = true;
    userInput.value = '';

    try
    {
        const response = await fetch(`/api/chat?prompt=${encodeURIComponent(message)}`);

        if (!response.ok)
        {
            throw new Error('Failed to get response from the server');
        }

        const data = await response.text();  // Assuming the response is a plain string

        addMessage(data, 'bot');
    }
     catch (error)
    {
        addMessage('Error: ' + error.message, 'bot');
    }
    finally
    {
        document.getElementById('send-button').disabled = false;
    }
}

document.getElementById('user-input').addEventListener('keypress', function(event)
{
    if (event.key === 'Enter')
    {
        sendMessage();
    }
});

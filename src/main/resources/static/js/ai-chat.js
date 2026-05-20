let isProcessing = false;

function appendMessage(sender, message) {

    const widget = document.getElementById("ai-chat-widget");

    widget.classList.add("chat-expanded");

    const intro = document.getElementById("aiIntro");

    if (intro) {

        intro.remove();
    }

    const responseBox = document.getElementById("aiResponse");

    const messageDiv = document.createElement("div");

    messageDiv.classList.add("chat-message");

    if (sender === "You") {

        messageDiv.classList.add("user-message");

    } else {

        messageDiv.classList.add("ai-message");
    }

    messageDiv.innerHTML = `
        <div class="message-sender">${sender}</div>
        <div class="message-text">${message}</div>
    `;

    responseBox.appendChild(messageDiv);

    // ONLY when USER asks question
 if (sender === "You") {

    setTimeout(() => {

        const targetPosition =
            messageDiv.offsetTop - (responseBox.clientHeight * 0.3);

        responseBox.scrollTo({

            top: targetPosition,

            behavior: "smooth"
        });

    }, 50);
}
}

function askAi(question) {

    if (isProcessing) return;

    isProcessing = true;

    const input = document.getElementById("aiQuestion");

    const askButton = document.querySelector(".ask-btn");

    input.disabled = true;

    if (askButton) {

        askButton.disabled = true;
    }

    appendMessage("You", question);

    const responseBox = document.getElementById("aiResponse");

    const thinkingDiv = document.createElement("div");

    thinkingDiv.classList.add("chat-message", "ai-message");

    thinkingDiv.id = "thinkingMessage";

    thinkingDiv.innerHTML = `
        <div class="message-sender">AI</div>

        <div class="message-text typing-indicator">
            <span></span>
            <span></span>
            <span></span>
        </div>
    `;

    responseBox.appendChild(thinkingDiv);

    fetch("/api/ai/ask", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            question
        })

    })
    .then(res => res.json())

    .then(data => {

        const thinking = document.getElementById("thinkingMessage");

        if (thinking) {

            thinking.remove();
        }

        // NO SCROLL HERE
        appendMessage("AI", data.answer);
    })

    .catch(() => {

        const thinking = document.getElementById("thinkingMessage");

        if (thinking) {

            thinking.remove();
        }

        appendMessage("AI", "⚠️ Something went wrong.");
    })

    .finally(() => {

        isProcessing = false;

        input.disabled = false;

        if (askButton) {

            askButton.disabled = false;
        }

        input.focus();
    });
}

function askCustomQuestion() {

    if (isProcessing) return;

    const input = document.getElementById("aiQuestion");

    const q = input.value.trim();

    if (!q) return;

    input.value = "";

    askAi(q);
}

function toggleAiChat() {

    const widget = document.getElementById("ai-chat-widget");

    widget.style.display =
        widget.style.display === "flex"
            ? "none"
            : "flex";
}

document
    .getElementById("aiQuestion")
    .addEventListener("keypress", function(event) {

        if (event.key === "Enter") {

            event.preventDefault();

            askCustomQuestion();
        }
    });
function askAi(question) {
    const responseBox = document.getElementById("aiResponse");
    const input = document.getElementById("aiQuestion");

    responseBox.innerText = "🤖 AI is thinking...";
    input.disabled = true;

    fetch("/api/ai/ask", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ question })
    })
        .then(res => res.json())
        .then(data => {
            responseBox.innerText = data.answer;
        })
        .catch(() => {
            responseBox.innerText = "⚠️ Something went wrong.";
        })
        .finally(() => {
            input.disabled = false;
            input.focus();
        });
}

function askCustomQuestion() {
    const input = document.getElementById("aiQuestion");
    const q = input.value.trim();
    if (!q) return;
    input.value = "";
    askAi(q);
}

function toggleAiChat() {
    const widget = document.getElementById("ai-chat-widget");
    widget.style.display =
        widget.style.display === "flex" ? "none" : "flex";
}

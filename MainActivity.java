import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView chatDisplay;
    private EditText userInput;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatDisplay = findViewById(R.id.chatDisplay);
        userInput = findViewById(R.id.userInput);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleUserInput();
            }
        });
    }

    private void handleUserInput() {
        String userMessage = userInput.getText().toString();
        appendToChat("You: " + userMessage);

        // Here, you can add logic to process the user's message and generate a bot response.
        String botResponse = getBotResponse(userMessage);
        appendToChat("Bot: " + botResponse);

        userInput.setText(""); // Clear the input field after sending a message.
    }

    private String getBotResponse(String userMessage) {
        // Simple example: You can define predefined responses based on user input.
        if (userMessage.contains("hello")) {
            return "Hello! How can I assist you?";
        } else if (userMessage.contains("how are you")) {
            return "I'm just a computer program, but I'm here to help!";
        } else {
            return "I'm sorry, I don't understand. Please ask another question.";
        }
    }

    private void appendToChat(String message) {
        chatDisplay.append("\n" + message);
    }
}

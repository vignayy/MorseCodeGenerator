package com.example.morsecodegenerator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;
    private Button convertButton;
    private TextView outputTextView;

    // Define the Morse code mappings using a HashMap
    private Map<Character, String> morseMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        convertButton = findViewById(R.id.convertButton);
        outputTextView = findViewById(R.id.outputTextView);

        // Initialize the Morse code mappings
        initializeMorseMap();

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = inputEditText.getText().toString();
                String morseCode = convertToMorse(inputText);
                outputTextView.setText(morseCode);
            }
        });
    }

    private void initializeMorseMap() {
        // Alphabets
        morseMap.put('A', ".-");
        morseMap.put('B', "-...");
        morseMap.put('C', "-.-.");
        morseMap.put('D', "-..");
        morseMap.put('E', ".");
        morseMap.put('F', "..-.");
        morseMap.put('G', "--.");
        morseMap.put('H', "....");
        morseMap.put('I', "..");
        morseMap.put('J', ".---");
        morseMap.put('K', "-.-");
        morseMap.put('L', ".-..");
        morseMap.put('M', "--");
        morseMap.put('N', "-.");
        morseMap.put('O', "---");
        morseMap.put('P', ".--.");
        morseMap.put('Q', "--.-");
        morseMap.put('R', ".-.");
        morseMap.put('S', "...");
        morseMap.put('T', "-");
        morseMap.put('U', "..-");
        morseMap.put('V', "...-");
        morseMap.put('W', ".--");
        morseMap.put('X', "-..-");
        morseMap.put('Y', "-.--");
        morseMap.put('Z', "--..");

        // Numbers
        morseMap.put('0', "-----");
        morseMap.put('1', ".----");
        morseMap.put('2', "..---");
        morseMap.put('3', "...--");
        morseMap.put('4', "....-");
        morseMap.put('5', ".....");
        morseMap.put('6', "-....");
        morseMap.put('7', "--...");
        morseMap.put('8', "---..");
        morseMap.put('9', "----.");

        // Punctuation
        morseMap.put('.', ".-.-.-");
        morseMap.put(',', "--..--");
        morseMap.put('?', "..--..");
        morseMap.put('!', "-.-.--");
        morseMap.put('/', "-..-.");
        morseMap.put('(', "-.--.");
        morseMap.put(')', "-.--.-");
        morseMap.put('&', ".-...");
        morseMap.put(':', "---...");
        morseMap.put(';', "-.-.-.");
        morseMap.put('=', "-...-");
        morseMap.put('+', ".-.-.");
        morseMap.put('-', "-....-");
        morseMap.put('_', "..--.-");
        morseMap.put('"', ".-..-.");
        morseMap.put('$', "...-..-");
        morseMap.put('@', ".--.-.");
    }

    private String convertToMorse(String input) {
        StringBuilder morseCode = new StringBuilder();
        for (char ch : input.toUpperCase().toCharArray()) {
            if (morseMap.containsKey(ch)) {
                morseCode.append(morseMap.get(ch)).append(" ");
            } else {
                // Ignore unsupported characters or add a placeholder for unknown characters
                morseCode.append(" ");
            }
        }
        return morseCode.toString();
    }
}

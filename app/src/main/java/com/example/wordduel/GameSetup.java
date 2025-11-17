package com.example.wordduel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameSetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_setup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Add button functionality
        setupButtons();
    }

    private void setupButtons() {
        // MENU Button - Goes back to MainActivity
        Button menuButton = findViewById(R.id.menu);
        menuButton.setOnClickListener(v -> {
            finish(); // Close this activity and go back to MainActivity
        });

        // START Button - Goes to ActiveGameScreen
        Button startButton = findViewById(R.id.start);
        startButton.setOnClickListener(v -> {
            Intent intent = new Intent(GameSetup.this, ActiveGameScreen.class);
            startActivity(intent);
        });
    }
}
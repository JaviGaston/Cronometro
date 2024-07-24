package com.example.cronometro;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements ICronometer.ICronometerListener {
    private TextView timeView;
    private boolean isInitialized = false;
    private boolean isCancelled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button startButton = findViewById(R.id.button);
        timeView = findViewById(R.id.textViewSegundos);
        startButton.setOnClickListener(view -> {
            if (!isInitialized) {
                Cronometer.getInstance().executeCronometer();
                isInitialized = true;
            }
        });
        Cronometer.getInstance().setCronometerListener(this);

        Button stopButton = findViewById(R.id.buttonStop);
        stopButton.setOnClickListener(view -> {

        });

        stopButton.setOnLongClickListener(view -> {
            isCancelled = Cronometer.getInstance().cancelCronometer();
            if (isCancelled){
                timeView.setText("00:00:00");
                isInitialized = false;
            }
            return true;
        });

    }

    @Override
    public void onCronometerTick(String time) {
        timeView.setText(time);
    }
}
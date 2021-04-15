package com.example.call_recorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ToggleButton button;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
        button = findViewById(R.id.button);
    }

    public void toogleButton(View view) {
        boolean checked = ((ToggleButton) view).isChecked();

        if (checked) {
            Intent intent = new Intent(this, RecordingService.class);
            startService(intent);
            Toast.makeText(getApplicationContext(), "Call Recorder Has Started", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, RecordingService.class);
            stopService(intent);
            Toast.makeText(getApplicationContext(), "Call Recorder Has been Stoped", Toast.LENGTH_LONG).show();
        }
    }
}
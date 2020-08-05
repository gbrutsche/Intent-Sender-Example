package com.example.sender;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn = findViewById(R.id.send);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/json");
        intent.putExtra(Intent.EXTRA_TEXT, "{\"text\":\"test\"}");

        final Intent chooser = Intent.createChooser(intent, "Choose App");

        // Verify the intent will resolve to at least one activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
}
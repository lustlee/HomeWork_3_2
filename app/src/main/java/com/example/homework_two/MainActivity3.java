package com.example.homework_two;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    EditText ed2;
    Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ed2 = findViewById(R.id.ed2);
        btn5 = findViewById(R.id.btn5);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textEntered = ed2.getText().toString();

                Context context = MainActivity3.this;
                Class destinationActivity = MainActivity.class;

                Intent activityMain = new Intent(context, destinationActivity);
                activityMain.putExtra(Intent.EXTRA_TEXT, textEntered);
                startActivity(activityMain);
            }
        });
    }

}
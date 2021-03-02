package com.example.homework_two;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;
    TextView textView;

    EditText numberEntry;
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        textView = findViewById(R.id.textView);


        btn1.setOnClickListener(v -> {
            Intent intentCamera = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
            startActivity(intentCamera);
        });
        btn2.setOnClickListener(v -> {
            String phone = "tel: (+996) 550 699 556 ";
            Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse(phone));
            startActivity(intentContact);
        });

        btn3.setOnClickListener(v -> {
            String url = "The Colosseum";
            Intent intentGoogle = new Intent(Intent.ACTION_WEB_SEARCH);
            intentGoogle.putExtra(SearchManager.QUERY, url);
            startActivity(intentGoogle);

        });

        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            startActivityForResult(intent, 202);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED){
            if (resultCode == 202) {
                String valueEdit = data.getStringExtra("key");
                textView.setText(valueEdit);
            }
        }
    }

}
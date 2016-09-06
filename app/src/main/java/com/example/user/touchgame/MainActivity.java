package com.example.user.touchgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }

    public void five(View v){
        Intent intent = new Intent(getApplicationContext(), TouchGame.class);
        intent.putExtra("second",5);
        startActivity(intent);
    }

    public void ten(View v){
        Intent intent = new Intent(getApplicationContext(), TouchGame.class);
        intent.putExtra("second",10);
        startActivity(intent);
    }
}

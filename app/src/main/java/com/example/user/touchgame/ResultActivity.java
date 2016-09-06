package com.example.user.touchgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
//TODO: 랭킹 구현, 꾸미기
    private int count;
    private TextView tv, r1, r2, r3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Intent intent = getIntent();
        count = intent.getIntExtra("count",0);
        tv=(TextView)findViewById(R.id.textView2);
        r1=(TextView)findViewById(R.id.textView3);
        r2=(TextView)findViewById(R.id.textView4);
        r3=(TextView)findViewById(R.id.textView5);

        SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int f = sp.getInt("f",0);
        int s = sp.getInt("s",0);
        int t = sp.getInt("t",0);

        tv.setText(""+count);

        if(count>f){
            f=count;
            editor.putInt("f",count);
        }else if(count>s){
            s=count;
            editor.putInt("s",count);
        }else if(count>t){
            t=count;
            editor.putInt("t",count);
        }
        editor.apply();

        r1.setText("1. "+f);
        r2.setText("2. "+s);
        r3.setText("3. "+t);

    }

    public void home(View v){
        this.finish();
    }
}

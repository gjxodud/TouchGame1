package com.example.user.touchgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
//TODO: 랭킹 구현, 꾸미기
    private TextView tv, r1, r2, r3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Intent intent = getIntent();
        int count = intent.getIntExtra("count",0);
        int second = intent.getIntExtra("second",5);
        tv=(TextView)findViewById(R.id.textView2);
        r1=(TextView)findViewById(R.id.textView3);
        r2=(TextView)findViewById(R.id.textView4);
        r3=(TextView)findViewById(R.id.textView5);

        tv.setText(second+"s "+count);

        SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int f, s, t;
        if(second == 5){
            f = sp.getInt("f5",0);
            s = sp.getInt("s5",0);
            t = sp.getInt("t5",0);
        }else{
            f = sp.getInt("f",0);
            s = sp.getInt("s",0);
            t = sp.getInt("t",0);
        }

        r1.setText("1. "+f);
        r2.setText("2. "+s);
        r3.setText("3. "+t);




        if(second == 5){

            if(count>f){
                f=count;
                editor.putInt("f5",count);
                r1.setText("1. "+f);
                r1.setTextColor(Color.parseColor("#FF0000"));
            }else if(count>s){
                s=count;
                editor.putInt("s5",count);
                r2.setText("2. "+s);
                r2.setTextColor(Color.parseColor("#FF0000"));
            }else if(count>t){
                t=count;
                editor.putInt("t5",count);
                r3.setText("3. "+t);
                r3.setTextColor(Color.parseColor("#FF0000"));
            }

        }else{

            if(count>f){
                t=s;
                s=f;
                f=count;
                editor.putInt("f",count);
                r1.setText("1. "+f);
                r1.setTextColor(Color.parseColor("#FF0000"));
            }else if(count>s){
                t=s;
                s=count;
                editor.putInt("s",count);
                r2.setText("2. "+s);
                r2.setTextColor(Color.parseColor("#FF0000"));
            }else if(count>t){
                t=count;
                editor.putInt("t",count);
                r3.setText("3. "+t);
                r3.setTextColor(Color.parseColor("#FF0000"));
            }
        }

        editor.apply();



    }

}

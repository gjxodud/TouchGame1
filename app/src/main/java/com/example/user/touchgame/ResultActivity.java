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
//TODO: 내 점수와 초 출력 다른 textview 사용하기
    private TextView tv, r1, r2, r3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Intent intent = getIntent();
        int count = intent.getIntExtra("count",-1);
        int second = intent.getIntExtra("second",5);

        String co;
        if(count<0) co = "";
        else co = "내 점수 "+count;

        tv=(TextView)findViewById(R.id.textView2);
        r1=(TextView)findViewById(R.id.textView3);
        r2=(TextView)findViewById(R.id.textView4);
        r3=(TextView)findViewById(R.id.textView5);

        tv.setText(second+"초\n\n"+co);

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


        if(count >= 0){
            if(second == 5){

                if(count>=f){
                    t=s;
                    s=f;
                    f=count;
                    r1.setTextColor(Color.parseColor("#FF0000"));
                }else if(count>=s){
                    t=s;
                    s=count;
                    r2.setTextColor(Color.parseColor("#FF0000"));
                }else if(count>=t){
                    t=count;
                    r3.setTextColor(Color.parseColor("#FF0000"));
                }

                editor.putInt("f5",f);
                editor.putInt("s5",s);
                editor.putInt("t5",t);

            }else{
                if(count>=f){
                    t=s;
                    s=f;
                    f=count;
                    r1.setTextColor(Color.parseColor("#FF0000"));
                }else if(count>=s){
                    t=s;
                    s=count;
                    r2.setTextColor(Color.parseColor("#FF0000"));
                }else if(count>=t){
                    t=count;
                    r3.setTextColor(Color.parseColor("#FF0000"));
                }
                editor.putInt("f",f);
                editor.putInt("s",s);
                editor.putInt("t",t);
            }
            r1.setText("1. "+f);
            r2.setText("2. "+s);
            r3.setText("3. "+t);
            editor.apply();
        }
    }

}

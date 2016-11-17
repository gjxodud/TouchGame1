package com.example.user.touchgame;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
public class TouchGame extends AppCompatActivity {
    private int count=0;
    private boolean isStart = false;
    TextView textView1;
    TextView timeText;
    private int second;
    private int s;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_game);
        textView1 = (TextView) findViewById(R.id.textView);
        timeText = (TextView)findViewById(R.id.timeText);
        Intent intent = getIntent();
        second = intent.getIntExtra("second",10);
        s = second;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        if(!isStart){
            ThreadStart();
            isStart = true;
            TextView tv = (TextView)findViewById(R.id.touch);
            tv.setText("");
        }
        RelativeLayout container = (RelativeLayout)findViewById(R.id.container);
        switch(e.getAction()){
            case MotionEvent.ACTION_DOWN:
                count++;
                textView1.setText(""+count);
                container.setBackgroundResource(R.drawable.game1);
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                count++;
                textView1.setText(""+count);
                container.setBackgroundResource(R.drawable.game2);
                break;
        }

        return true;
    }

    private  void ThreadStart(){
        new Thread(){
            @Override
            public void run(){
                TimerProcess();
            }
        }.start();
    }

    private void TimerProcess(){
        int i = 0;

        while(i<=second*10){
            try{
                i++;
                handler.sendEmptyMessage(i/10);
                Thread.sleep(100);
            }catch (InterruptedException e){

            }
        }
        if(i>=second*10){
            Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
            intent.putExtra("count",count);
            intent.putExtra("second",s);
            startActivity(intent);
            this.finish();
        }
    }

    Handler handler = new Handler(){
        public void handleMessage(Message msg){
            timeText.setText(""+msg.what);
        };
    };

    public void onBackPressed(){
    }
}
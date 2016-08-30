package com.example.user.touchgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle; import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class TouchGame extends AppCompatActivity {
    public int count=0;
    TextView textView1;
    String str,str2;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_game);
        textView1 = (TextView) findViewById(R.id.textView) ;
        findViewById(R.id.button).setOnClickListener( new Button.OnClickListener() {
            public void onClick(View v) {
                count++;
                str = count + "";
                textView1.setText(str);
            }
        } );
    }
}
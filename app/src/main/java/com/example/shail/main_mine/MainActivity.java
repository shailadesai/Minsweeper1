package com.example.shail.main_mine;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.PerformanceTestCase;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.shail.main_mine.C_flow.context;
import static com.example.shail.main_mine.C_flow.h;


public class MainActivity extends AppCompatActivity {
    Button start;
    Button intermediate;
    Button Expert;
    Button Reset;

    TextView time;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer mediaPlayer =  MediaPlayer.create(MainActivity.this,R.raw.rena);
        mediaPlayer.start();


        start = (Button) findViewById(R.id.ssbutton);
        Reset = (Button) findViewById(R.id.Reset);
        Expert = (Button) findViewById(R.id.expert);
        intermediate = (Button) findViewById(R.id.intermediate);
        time = (TextView) findViewById(R.id.Time);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(15000, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        count++;
                        time.setText(Integer.toString(count));
                    }

                    @Override
                    public void onFinish() {
                        C_flow cls3 = new C_flow();
                        C_flow.onGameLost();


                    }
                }.start();
            }
        });
        Expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Creategrid cr = new Creategrid();
                    cr.Createdgrid(25, 9, 9);
                    setContentView(R.layout.activity_main);





                }
            }
        });
        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                {
                    setContentView(R.layout.activity_main);
                    Creategrid cr = new Creategrid();
                    cr.Createdgrid(47, 9, 9);

                }
            }
        });
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    MediaPlayer mediaPlayer =  MediaPlayer.create(MainActivity.this,R.raw.rena);
                    mediaPlayer.start();
                    setContentView(R.layout.activity_main);


                }
            }
        });
    }

}
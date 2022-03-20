package com.macelitech.catchthekenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView timeText;
    TextView scoreText;
    Integer score_count;
    Integer counter;
    Handler handler;
    Runnable runnable;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView imageView16;
    ImageView[] imageArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeText = findViewById(R.id.time);
        scoreText = findViewById(R.id.score);
        score_count=0;
        counter = 15;
        timeText.setText("Time : "+counter);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        imageView14 = findViewById(R.id.imageView14);
        imageView15 = findViewById(R.id.imageView15);
        imageView16 = findViewById(R.id.imageView16);

        imageArray = new ImageView[] {
                imageView1,
                imageView2,
                imageView3,
                imageView4,
                imageView5,
                imageView6,
                imageView7,
                imageView8,
                imageView9,
                imageView10,
                imageView11,
                imageView12,
                imageView13,
                imageView14,
                imageView15,
                imageView16,
        };

        hideImages();






        new CountDownTimer(15000, 1000) { // use this for countdown timer but in OnCreate
            @Override
            public void onTick(long l) {
                timeText.setText("Left : " + l / 1000);

            }

            @Override
            public void onFinish() {

                Toast.makeText(MainActivity.this, "Time finished", Toast.LENGTH_LONG).show();
                handler.removeCallbacks(runnable);
                for(ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);

                }
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Restart Game");
                alert.setMessage("Are you sure to restart game ?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //restart
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);

                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(MainActivity.this,"Game Over", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
            }
        }.start();

    }


    public void catchup(View view){
        score_count++;
        scoreText.setText("Score : " + score_count);
    }
    public void hideImages(){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);

                }
                Random random = new Random();
                int i = random.nextInt(16);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);
    }
}
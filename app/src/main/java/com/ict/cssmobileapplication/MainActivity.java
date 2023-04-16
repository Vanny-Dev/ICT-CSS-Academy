package com.ict.cssmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    ImageButton coc_oneBtn;
    ImageButton coc_twoBtn;
    ImageButton coc_threeBtn;
    ImageButton coc_fourBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //COC 1
        coc_oneBtn = (ImageButton) findViewById(R.id.btn1);

        coc_oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, cocOneActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        //COC 2
        coc_twoBtn = (ImageButton) findViewById(R.id.btn2);

        coc_twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, cocTwoActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        //COC 3
        coc_threeBtn = (ImageButton) findViewById(R.id.btn3);

        coc_threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, cocThreeActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        //COC 4
        coc_fourBtn = (ImageButton) findViewById(R.id.btn4);

        coc_fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View d) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, cocFourActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });




        //VIDEO BG
        /*VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.bg);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });
        videoView.start();*/

        //OPTIONAL
        /*Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);*/
    }


}
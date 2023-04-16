package com.ict.cssmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton coc_oneBtn;
    ImageButton coc_twoBtn;
    ImageButton coc_threeBtn;
    ImageButton coc_fourBtn;

    FrameLayout coc_1, coc_2, coc_3, coc_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //COC 1
        coc_oneBtn = (ImageButton) findViewById(R.id.btn1);
        //COC 2
        coc_twoBtn = (ImageButton) findViewById(R.id.btn2);
        //COC 3
        coc_threeBtn = (ImageButton) findViewById(R.id.btn3);
        //COC 4
        coc_fourBtn = (ImageButton) findViewById(R.id.btn4);

        // Frames to click
        coc_1 = findViewById(R.id.coc1);
        coc_2 = findViewById(R.id.coc2);
        coc_3 = findViewById(R.id.coc3);
        coc_4 = findViewById(R.id.coc4);

        //VIDEO BG
        /*VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.bg);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });
        videoView.start();

        //OPTIONAL
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);*/
    }

    @Override
    public void onClick(View view) {
        if (coc_1 == view) {
            // First window

        }else if(coc_2 == view){
            // Second Window

        }else if(coc_3 == view){
            // Third Window

        }else if(coc_4 == view){
            // Fourth Window

        }
    }
}
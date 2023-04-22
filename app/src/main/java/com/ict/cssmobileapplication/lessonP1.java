package com.ict.cssmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

public class lessonP1 extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_lesson_p1);

        /*VideoView videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.bg;

        //OPTIONAL
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);*/

		VideoView view = new VideoView(this);
		try {
			Uri url = Uri.parse("I don't know muna hahaha");
			MediaController control = new MediaController(this);
			view.setVideoURI(url);
			view.setMediaController(control);
			control.setAnchorView(view);
			view.start();
		}catch (Exception e){
			Toast.makeText(lessonP1.this, "Error" + e.getMessage(), Toast.LENGTH_LONG).show();
		}
		setContentView(view);
	}
}
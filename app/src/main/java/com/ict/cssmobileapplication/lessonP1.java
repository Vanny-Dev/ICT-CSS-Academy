package com.ict.cssmobileapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

public class lessonP1 extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setTitle("");
		setTheme(android.R.style.Theme_DeviceDefault_NoActionBar);
		LinearLayout layout = new LinearLayout(this);
		VideoView view = new VideoView(this);
		try {
			Uri url = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bg);
			MediaController control = new MediaController(this);
			view.setVideoURI(url);
			view.setMediaController(control);
			control.setAnchorView(view);
			view.start();
		}catch (Exception e){
			Toast.makeText(lessonP1.this, "Error" + e.getMessage(), Toast.LENGTH_LONG).show();
		}

		layout.setOrientation(LinearLayout.VERTICAL);
		layout.setGravity(Gravity.CENTER);

		layout.addView(view);
		setContentView(layout);
	}
}
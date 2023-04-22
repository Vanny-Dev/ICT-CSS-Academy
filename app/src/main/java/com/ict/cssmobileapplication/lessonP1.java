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
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
		setTitle("");
		setTheme(android.R.style.Theme_DeviceDefault_NoActionBar);
		LinearLayout layout = new LinearLayout(this);
		VideoView view = new VideoView(this);
		try {
			Uri url = Uri.parse("https://drive.google.com/u/0/uc?id=1-2wG-h1IqJ3FRGufDeQQduQBxrBroXjq&export=download&confirm=t&uuid=fb3cf3a3-9dea-49ae-a2b2-c8e116dc042f&at=ANzk5s6fvolLhDqFHQKXnIP4DWZ0:1682145049826" );//"android.resource://" + getPackageName() + "/" + R.raw.bg);
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

		layout.addView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
		setContentView(layout);
	}
}
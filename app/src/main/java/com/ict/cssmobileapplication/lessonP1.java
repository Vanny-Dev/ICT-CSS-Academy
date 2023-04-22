package com.ict.cssmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.os.Bundle;

public class lessonP1 extends AppCompatActivity {

	SharedPreferences pref;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
		pref = getSharedPreferences(preferencesData.PREFERENCE_NAME, MODE_PRIVATE);
		setTitle(pref.getString(preferencesData.PREFERENCE_VIDEO_TITLE, ""));
		setTheme(android.R.style.Theme_DeviceDefault_NoActionBar);
		LinearLayout layout = new LinearLayout(this);
		VideoView view = new VideoView(this);
		try {
			Uri url = Uri.parse(pref.getString(preferencesData.PREFERENCE_VIDEO, "")); //"" );//"android.resource://" + getPackageName() + "/" + R.raw.bg);
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

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

		layout.addView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
		setContentView(layout);
	}
}
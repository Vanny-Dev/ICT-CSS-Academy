package com.ict.cssmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

	FrameLayout coc_1, coc_2, coc_3, coc_4;
	SharedPreferences pref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		pref = getSharedPreferences(preferencesData.PREFERENCE_NAME, MODE_PRIVATE);
		setContentView(R.layout.activity_main);

		// Frames to click
		coc_1 = findViewById(R.id.coc1);
		coc_2 = findViewById(R.id.coc2);
		coc_3 = findViewById(R.id.coc3);
		coc_4 = findViewById(R.id.coc4);

		// on clicks
		coc_1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				pref.edit().putString(preferencesData.PREFERENCE_CURRENT_ACTIVITY, "COC 1").commit();
				pref.edit().putString(preferencesData.PREFERENCE_TITLE, getString(R.string.coc_1)).commit();
				startActivity(new Intent(MainActivity.this, cocActivity.class));
			}
		});
		coc_2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				pref.edit().putString(preferencesData.PREFERENCE_CURRENT_ACTIVITY, "COC 2").commit();
				pref.edit().putString(preferencesData.PREFERENCE_TITLE, getString(R.string.coc_2)).commit();
				startActivity(new Intent(MainActivity.this, cocActivity.class));
			}
		});
		coc_3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				pref.edit().putString(preferencesData.PREFERENCE_CURRENT_ACTIVITY, "COC 3").commit();
				pref.edit().putString(preferencesData.PREFERENCE_TITLE, getString(R.string.coc_3)).commit();
				startActivity(new Intent(MainActivity.this, cocActivity.class));
			}
		});
		coc_4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				pref.edit().putString(preferencesData.PREFERENCE_CURRENT_ACTIVITY, "COC 4").commit();
				pref.edit().putString(preferencesData.PREFERENCE_TITLE, getString(R.string.coc_4)).commit();
				startActivity(new Intent(MainActivity.this, cocActivity.class));
			}
		});

		// Clear Preferences
		pref.edit().remove(preferencesData.PREFERENCE_CURRENT_ACTIVITY).commit();
		pref.edit().remove(preferencesData.PREFERENCE_TITLE).commit();
	}
}
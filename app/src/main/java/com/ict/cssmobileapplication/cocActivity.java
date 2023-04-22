package com.ict.cssmobileapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Collections;

public class cocActivity extends AppCompatActivity {
	SharedPreferences pref;
	ListView listsView;
	Lists adapter;
	ArrayList<String> lists;
	AppCompatTextView txt, noViews;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		pref = getSharedPreferences(preferencesData.PREFERENCE_NAME, MODE_PRIVATE);
		pref.edit().remove(preferencesData.PREFERENCE_VIDEO_TITLE)
				.remove(preferencesData.PREFERENCE_VIDEO).apply();
		setTitle(pref.getString(preferencesData.PREFERENCE_TITLE, ""));
		setContentView(R.layout.coc_layout);
		txt = findViewById(R.id.cocTitle);
		noViews = findViewById(R.id.noViews);
		String name = pref.getString(preferencesData.PREFERENCE_CURRENT_ACTIVITY, "").replace(" ", "_").toLowerCase();

		txt.setText(pref.getString(preferencesData.PREFERENCE_TITLE, ""));

		noViews.setText("Comming soon...");

		JSONObject json = MyLists.json(this);
		String[] _lists = {};

		try{
			assert json != null;
			_lists = MyLists.jsonArrays(json.getJSONObject(name), "names");
		}catch(Exception ignored){}

		listsView = findViewById(R.id.cocLists);
		lists = new ArrayList<>();
		adapter = new Lists(this, lists);
		if (_lists != null) {
			Collections.addAll(lists, _lists);
		}
		adapter.notifyDataSetChanged();
		adapter.notifyDataSetInvalidated();
		listsView.setAdapter(adapter);

		listsView.setOnItemClickListener((adapterView, view, i, l) -> {
			String[] __lists = {};
			try{
				__lists = MyLists.jsonArrays(json.getJSONObject(name), "links");
			}catch(Exception ignored){}

			assert __lists != null;
			String name1 = String.valueOf(__lists[i]);

			pref.edit().putString(preferencesData.PREFERENCE_VIDEO_TITLE, String.valueOf(listsView.getItemAtPosition(i)))
					.putString(preferencesData.PREFERENCE_VIDEO, name1).apply();

			// Don't use the commit or apply here, to reset the data
			// Open new activity? add this below
			startActivity(new Intent(cocActivity.this, lessonP1.class));
		});

		assert _lists != null;
		if(_lists.length > 0){
			noViews.setVisibility(View.GONE);
		}else{
			listsView.setVisibility(View.GONE);
		}
	}
}

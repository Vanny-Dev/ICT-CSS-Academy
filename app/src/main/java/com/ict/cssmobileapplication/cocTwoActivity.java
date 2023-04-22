package com.ict.cssmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.ArrayList;

public class cocTwoActivity extends AppCompatActivity {

	ListView listsView;
	Lists adapter;
	ArrayList<String> lists;
	SharedPreferences pref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Preferences
		pref = getSharedPreferences(preferencesData.PREFERENCE_NAME, MODE_PRIVATE);
		setContentView(R.layout.activity_coc_two);

		JSONObject json = MyLists.json(this);
		String[] _lists = {};
		try{
			_lists = MyLists.jsonArrays(json.getJSONObject("coc_2"), "names");
		}catch(Exception e){}

		// layout
		listsView = findViewById(R.id.coc_2_lists);


		lists = new ArrayList<String>();
		adapter = new Lists(this, lists);

		for(int i = 0; i < _lists.length; i++){
			lists.add(_lists[i]);
		}

		adapter.notifyDataSetChanged();
		adapter.notifyDataSetInvalidated();

		listsView.setAdapter(adapter);

		listsView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				String[] __lists = {};
				try{
					__lists = MyLists.jsonArrays(json.getJSONObject("coc_2"), "links");
				}catch(Exception e){}
				String name = String.valueOf(__lists[i]);
				pref.edit().putString(preferencesData.PREFERENCE_CURRENT_ACTIVITY, name);
				// Don't use the commit or apply here, to reset the data
				// Open new activity? add this below
				startActivity(new Intent(cocTwoActivity.this, lessonP1.class));
			}
		});
	}
}
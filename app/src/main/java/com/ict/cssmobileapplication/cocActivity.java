package com.ict.cssmobileapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import org.json.JSONObject;

import java.util.ArrayList;

public class cocActivity extends AppCompatActivity {
	SharedPreferences pref;
	ListView listsView;
	Lists adapter;
	ArrayList<String> lists;
	AppCompatTextView txt, noViews;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		pref = getSharedPreferences(preferencesData.PREFERENCE_NAME, MODE_PRIVATE);

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
			_lists = MyLists.jsonArrays(json.getJSONObject(name), "names");
		}catch(Exception e){}

		listsView = findViewById(R.id.cocLists);
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
					__lists = MyLists.jsonArrays(json.getJSONObject(name), "links");
				}catch(Exception e){}
				String name = String.valueOf(__lists[i]);
				pref.edit().putString(preferencesData.PREFERENCE_CURRENT_ACTIVITY, name);
				// Don't use the commit or apply here, to reset the data
				// Open new activity? add this below
				startActivity(new Intent(cocActivity.this, lessonP1.class));
			}
		});

		if(_lists.length > 0){
			noViews.setVisibility(View.GONE);
		}else{
			listsView.setVisibility(View.GONE);
		}
	}
}

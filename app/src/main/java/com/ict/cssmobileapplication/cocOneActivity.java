package com.ict.cssmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class cocOneActivity extends AppCompatActivity {

    ListView listsView;
    Lists adapter;
    ArrayList<String> lists;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Preferences
        pref = getSharedPreferences(preferencesData.PREFERENCE_NAME, MODE_PRIVATE);
        setContentView(R.layout.activity_coc_one);

        // layout
        listsView = findViewById(R.id.coc_1_lists);


        lists = new ArrayList<String>();
        adapter = new Lists(this, lists);

        for(int i = 0; i < MyLists.coc_1.length; i++){
            lists.add(MyLists.coc_1[i]);
        }

        adapter.notifyDataSetChanged();
        adapter.notifyDataSetInvalidated();

        listsView.setAdapter(adapter);

        listsView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = String.valueOf(listsView.getItemAtPosition(i));
                pref.edit().putString(preferencesData.PREFERENCE_CURRENT_ACTIVITY, name);
                // Don't use the commit or apply here, to reset the data
                // Open new activity? add this below
                startActivity(new Intent(cocOneActivity.this, lessonP1.class));
            }
        });


    }
}
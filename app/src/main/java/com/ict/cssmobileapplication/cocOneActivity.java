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

public class cocOneActivity extends AppCompatActivity {

    ListView listsView;
    ArrayAdapter<String> adapter;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Preferences
        pref = getSharedPreferences(preferencesData.PREFERENCE_NAME, MODE_PRIVATE);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MyLists.coc_1);

        // layout
        setContentView(R.layout.activity_coc_one);
        listsView = findViewById(R.id.coc_1_lists);

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
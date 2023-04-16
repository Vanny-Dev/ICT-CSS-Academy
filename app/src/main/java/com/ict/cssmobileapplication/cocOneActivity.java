package com.ict.cssmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cocOneActivity extends AppCompatActivity {

    Button coc_lp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coc_one);



        coc_lp1 = (Button) findViewById(R.id.lp1);

        coc_lp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                Intent intentLoadNewActivity = new Intent(cocOneActivity.this, lessonP1.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}
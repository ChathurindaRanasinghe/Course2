package com.example.course;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SelectViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_view);
    }

    //    public void ClickMaps(View view) {
//        Intent intent = new Intent(this, MapViewActivity.class);
//        startActivity(intent);
//    }
//
    public void ClickReg(View view) {
        Intent intent = new Intent(this, ViewCoursesActivity.class);
        startActivity(intent);
    }
}
package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserChoiceActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choice);
    }

    public void ClickUser(View view) {
        Intent intent = new Intent(this, SelectViewActivity.class);
        startActivity(intent);
    }


    public void ClickAdmin(View view) {
        Intent intent = new Intent(this, AddCoursesActivity.class);
        startActivity(intent);
    }

    public void ClickGuest(View view) {
        Intent intent = new Intent(this, ViewCoursesActivity2.class);
        startActivity(intent);
    }

    public void clickProfile(View view) {
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
    }

}
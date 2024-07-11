package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisteredCoursesActivity extends AppCompatActivity {


    TextView courseNameTextView, courseFeeTextView, courseBranchTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registed_courses);

        courseNameTextView = findViewById(R.id.textName);
        courseFeeTextView = findViewById(R.id.textcost);
        courseBranchTextView = findViewById(R.id.textbranch);

        // Get the data from the intent
        String courseName = getIntent().getStringExtra("courseName");
        String courseFee = getIntent().getStringExtra("courseFee");
        String courseBranch = getIntent().getStringExtra("courseBranch");

        // Set the data to the TextViews
        courseNameTextView.setText(courseName);
        courseFeeTextView.setText(courseFee);
        courseBranchTextView.setText(courseBranch);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, ViewCoursesActivity.class);
        startActivity(intent);
    }
}
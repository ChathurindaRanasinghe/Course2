package com.example.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewCoursesActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    DatabaseHelper myDB;
    ArrayList<String> courseID, courseName, courseFee, courseBranch, courseDuration,  startDate, regDate, publishDate;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_courses);

        recyclerView = findViewById(R.id.recycleView);

        myDB = new DatabaseHelper(ViewCoursesActivity.this);
        courseID = new ArrayList<>();
        courseName = new ArrayList<>();
        courseFee = new ArrayList<>();
        courseBranch = new ArrayList<>();
        courseDuration = new ArrayList<>();
        startDate = new ArrayList<>();
        regDate = new ArrayList<>();
        publishDate = new ArrayList<>();

        displayData();
        customAdapter = new CustomAdapter(ViewCoursesActivity.this, ViewCoursesActivity.this, courseID,courseName,courseFee,
                courseBranch,courseDuration,startDate,regDate,publishDate);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewCoursesActivity.this));
    }

    void displayData(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                courseID.add(cursor.getString(0));
                courseName.add(cursor.getString(1));
                courseFee.add(cursor.getString(2));
                courseBranch.add(cursor.getString(3));
                courseDuration.add(cursor.getString(4));
                startDate.add(cursor.getString(5));
                regDate.add(cursor.getString(6));
                publishDate.add(cursor.getString(7));
            }
        }
    }
}
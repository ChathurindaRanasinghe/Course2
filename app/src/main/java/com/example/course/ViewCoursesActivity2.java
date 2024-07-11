package com.example.course;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewCoursesActivity2 extends AppCompatActivity {


    RecyclerView recyclerView;
    DatabaseHelper myDB;
    ArrayList<String> courseID, courseName, courseFee, courseDuration, courseBranch, startDate, regDate, publishDate;
    CustomAdapter2 customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_courses);

        recyclerView = findViewById(R.id.recycleView);

        myDB = new DatabaseHelper(ViewCoursesActivity2.this);
        courseID = new ArrayList<>();
        courseName = new ArrayList<>();
        courseFee = new ArrayList<>();
        courseDuration = new ArrayList<>();
        courseBranch = new ArrayList<>();
        startDate = new ArrayList<>();
        regDate = new ArrayList<>();
        publishDate = new ArrayList<>();

        displayData();
        customAdapter = new CustomAdapter2(ViewCoursesActivity2.this, ViewCoursesActivity2.this, courseID,courseName,courseFee,
                courseBranch,courseDuration,startDate,regDate,publishDate);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewCoursesActivity2.this));
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
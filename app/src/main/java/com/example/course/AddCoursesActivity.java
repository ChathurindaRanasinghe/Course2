package com.example.course;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddCoursesActivity extends AppCompatActivity {

    private static final int STORAGE_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_courses);

        // Check and request storage permissions
        checkAndRequestPermissions();

        Intent intent = getIntent();

        Button courseAddButton = findViewById(R.id.addCourseBtn);

        //Add on click listener to save_button
        courseAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText courseNameEdit = findViewById(R.id.addName);
                EditText courseFeeEdit = findViewById(R.id.addFee);
                Spinner courseBranchesEdit = findViewById(R.id.addBranch);
                EditText courseDurationEdit = findViewById(R.id.addDuration);
                EditText coursePublishedDateEdit = findViewById(R.id.addPubDate);
                EditText courseRegDueDateEdit = findViewById(R.id.addRegDate);
                EditText courseStartDateEdit = findViewById(R.id.addStartDate);

                String courseName = courseNameEdit.getText().toString();
                String courseFee = courseFeeEdit.getText().toString();
                String courseBranches = courseBranchesEdit.getSelectedItem().toString();
                String courseDuration = courseDurationEdit.getText().toString();
                String coursePublishedDate = coursePublishedDateEdit.getText().toString();
                String courseRegDueDate = courseRegDueDateEdit.getText().toString();
                String courseStartDate = courseStartDateEdit.getText().toString();

                if (courseName.isEmpty() || courseFee.isEmpty() || courseBranches.isEmpty() || courseDuration.isEmpty() || coursePublishedDate.isEmpty() || courseRegDueDate.isEmpty() || courseStartDate.isEmpty()) {
                    Toast.makeText(AddCoursesActivity.this, "Please enter all required fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                DatabaseHelper dbCourses = new DatabaseHelper(AddCoursesActivity.this);
                dbCourses.addNewCourse(courseName, courseFee, courseBranches, courseDuration, coursePublishedDate, courseRegDueDate, courseStartDate);

                String addedCourseName = dbCourses.getCourseName();
                Toast.makeText(AddCoursesActivity.this, "A new course has been added: " + addedCourseName, Toast.LENGTH_SHORT).show();

                courseNameEdit.setText("");
                courseFeeEdit.setText("");
                courseBranchesEdit.setSelection(0);
                courseDurationEdit.setText("");
                coursePublishedDateEdit.setText("");
                courseRegDueDateEdit.setText("");
                courseStartDateEdit.setText("");
            }
        });
    }



    private void checkAndRequestPermissions() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            // Request the permissions
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
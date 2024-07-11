package com.example.course;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class CourseActivity extends AppCompatActivity {

    private LinearLayout parentLinearLayout;
    private List<String> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        parentLinearLayout = findViewById(R.id.parent);
        items = new ArrayList<>();
        items.add("Programming Basics - Colombo");
        items.add("Python for Beginners - Jaffna");
        items.add("Python for Beginners - Galle");
        items.add("JavaScript Basics - Gampaha");
        items.add("SQL Basics - Kottawa");
        addDynamicLayouts(items);
    }

    private void addDynamicLayouts(List<String> items) {
        LayoutInflater inflater = LayoutInflater.from(this);

        for (final String item : items) {
            View itemView = inflater.inflate(R.layout.course_item, parentLinearLayout, false);

            TextView textView = itemView.findViewById(R.id.textView);
            Button buttonDelete = itemView.findViewById(R.id.buttonDelete);

            textView.setText(item);

            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showConfirmationDialog(item, itemView);
                }
            });

            parentLinearLayout.addView(itemView);
        }
    }

    private void showConfirmationDialog(final String item, final View itemView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to delete this course?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                removeItem(itemView, item);
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }

    private void removeItem(View view, String item) {
        parentLinearLayout.removeView(view);
        items.remove(item);
    }
}
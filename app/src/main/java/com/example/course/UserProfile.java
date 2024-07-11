package com.example.course;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserProfile extends AppCompatActivity {

    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile); // Ensure this matches the XML filename

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        // Set OnClickListener for button1 (Notifications)
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start NotificationActivity
                Intent intent = new Intent(UserProfile.this, NotificationActivity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener for button2 (Registered Courses)
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start CourseActivity
                Intent intent = new Intent(UserProfile.this, CourseActivity.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickLogin(View view){
      Intent intent = new Intent(MainActivity.this,LoginPage.class);
      startActivity(intent);
    }
    public void onClickSignup (View view){
        Intent intent = new Intent(this,LoginPage.class);
        startActivity(intent);
    }

}
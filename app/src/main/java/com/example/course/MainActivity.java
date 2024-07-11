package com.example.course;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSignup(View view) {
        Intent i = new Intent(MainActivity.this, SignupPage.class);
        startActivity(i);
    }

    public void onClickGuest(View view) {
        Intent i = new Intent(MainActivity.this, SignupPage.class);
        startActivity(i);
    }

    public void onClickLogin(View view) throws ParseException {
        Intent i = new Intent(MainActivity.this, UserChoiceActivity.class);

//        DatabaseHandler dbHandler = new DatabaseHandler(this);
//
        EditText userName = (EditText) findViewById(R.id.editTextText);
        EditText password = (EditText) findViewById(R.id.editTextText2);
//        User matchedUser = dbHandler.getUser(userName.toString());
//        System.out.println(password);

//        if(password.toString()=="") {
        startActivity(i);
    }
//        } else if (password.toString()=="admin") {
//            startActivity(j);
//        }
//        else  {
////            // Throw error message
//        }


}

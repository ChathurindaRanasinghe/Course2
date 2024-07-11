package com.example.course;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;

public class SignupPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        Spinner spinner = findViewById(R.id.gender_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                SignupPage.this,
                R.array.Gender, // Ensure this matches the name of your string array
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onClickCancel(View view) {
        Intent i = new Intent(SignupPage.this, MainActivity.class);
        startActivity(i);
    }

    public void onClickSave(View view) throws ParseException {
        Intent i = new Intent(SignupPage.this, MainActivity.class);
        EditText name = (EditText) findViewById(R.id.editTextText3);
        EditText address = (EditText) findViewById(R.id.editTextTextPostalAddress);
        EditText livingCity = (EditText) findViewById(R.id.editTextText4);
        EditText dateOfBirth = (EditText) findViewById(R.id.editTextDate);
        Spinner gender = (Spinner) findViewById(R.id.gender_spinner);
        EditText nic = (EditText) findViewById(R.id.editTextText5);
        EditText emailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        EditText mobileNumber = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText userName = (EditText) findViewById(R.id.editTextText6);
        EditText password = (EditText) findViewById(R.id.editTextTextPassword);


        User signUpUser = new User(
                name.getText().toString(),
                address.getText().toString(),
                livingCity.getText().toString(),
                dateOfBirth.getText().toString(),
                (String) gender.getSelectedItem(),
                nic.getText().toString(),
                emailAddress.getText().toString(),
                mobileNumber.getText().toString(),
                userName.getText().toString(),
                password.getText().toString());

        DatabaseHandler dbHandler = new DatabaseHandler(this);

        dbHandler.addUser(signUpUser);

        startActivity(i);
    }
}

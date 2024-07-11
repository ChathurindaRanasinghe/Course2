package com.example.course;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;

public class User {
    String name;
    String address;
    String livingCity;
    Date dateofBirth;

    String gender;

    String nic;
    String emailAddress;
    int mobileNumber;
    String userName;
    String password;


    public User(String name,
                String address,
                String livingCity,
                String dateofBirth,
                String gender,
                String nic,
                String emailAddress,
                String mobileNumber,
                String userName,
                String password
    ) throws ParseException {
        this.name = name;
        this.address = address;
        this.livingCity = livingCity;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        this.dateofBirth = formatter.parse(dateofBirth);
        this.gender = gender;
        this.nic = nic;
        this.emailAddress = emailAddress;
        this.mobileNumber = Integer.parseInt(mobileNumber);
        this.userName = userName;
        this.password = password;



    }

    public String getPassword() {
        return this.password;
    }
}

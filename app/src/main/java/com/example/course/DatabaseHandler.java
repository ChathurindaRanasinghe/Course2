package com.example.course;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "userManager";
    private static final String TABLE_USERS = "users";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_LIVING_CITY = "livingCity";
    public static final String KEY_DATE_OF_BIRTH = "dateofBirth";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_NIC = "nic";
    public static final String KEY_EMAIL_ADDRESS = "emailAddress";
    public static final String KEY_MOBILE_NUMBER = "mobileNumber";
    public static final String KEY_USER_NAME = "userName";
    public static final String KEY_PASSWORD = "password";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + "name TEXT,"
                + "address TEXT,"
                + "livingCity TEXT,"
                + "dateofBirth TEXT," // Storing date as TEXT in "yyyy-MM-dd" format
                + "gender TEXT,"
                + "nic TEXT,"
                + "emailAddress TEXT,"
                + "mobileNumber INTEGER,"
                + "userName TEXT,"
                + "password TEXT"
                + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // Create tables again
        onCreate(db);
    }

    // code to add the new User
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.name);
        values.put(KEY_ADDRESS, user.address);
        values.put(KEY_LIVING_CITY, user.livingCity);

        // Format date as string
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        values.put(KEY_DATE_OF_BIRTH, formatter.format(user.dateofBirth));

        values.put(KEY_GENDER, user.gender);
        values.put(KEY_NIC, user.nic);
        values.put(KEY_EMAIL_ADDRESS, user.emailAddress);
        values.put(KEY_MOBILE_NUMBER, user.mobileNumber);
        values.put(KEY_USER_NAME, user.userName);
        values.put(KEY_PASSWORD, user.password);

        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        // Closing database connection
        db.close();
    }

    // code to get the single User
    public User getUser(String username) throws ParseException {
        SQLiteDatabase db = this.getReadableDatabase();
        User user = null;

        Cursor cursor = db.query(TABLE_USERS, new String[] {
                        KEY_ID, KEY_NAME, KEY_ADDRESS, KEY_LIVING_CITY,
                        KEY_DATE_OF_BIRTH, KEY_GENDER, KEY_NIC,
                        KEY_EMAIL_ADDRESS, KEY_MOBILE_NUMBER, KEY_USER_NAME, KEY_PASSWORD
                },
                KEY_USER_NAME + "=?",
                new String[] { username },
                null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            // Parse cursor data into User object
            String name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
            String address = cursor.getString(cursor.getColumnIndex(KEY_ADDRESS));
            String livingCity = cursor.getString(cursor.getColumnIndex(KEY_LIVING_CITY));
            String dateOfBirthStr = cursor.getString(cursor.getColumnIndex(KEY_DATE_OF_BIRTH));
            String gender = cursor.getString(cursor.getColumnIndex(KEY_GENDER));
            String nic = cursor.getString(cursor.getColumnIndex(KEY_NIC));
            String emailAddress = cursor.getString(cursor.getColumnIndex(KEY_EMAIL_ADDRESS));
            String mobileNumber = cursor.getString(cursor.getColumnIndex(KEY_MOBILE_NUMBER));
            String userName = cursor.getString(cursor.getColumnIndex(KEY_USER_NAME));
            String password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));


            // Create User object
            user = new User(name, address, livingCity, dateOfBirthStr, gender, nic, emailAddress, mobileNumber, userName, password);
        }

        // Close cursor and database connection
        if (cursor != null) {
            cursor.close();
        }
        db.close();

        return user;
    }






}
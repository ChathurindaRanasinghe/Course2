package com.example.course;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    //DB variables
    private static final String DB_NAME = "easy_enroll_db";
    private static final int DB_VERSION = 1;

    //Variables for table
    private static final String TABLE_NAME = "courses";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String FEE_COL = "fee";
    private static final String BRANCH_COL = "branches";
    private static final String DURATION_COL = "duration";
    private static final String PUBLISH_COL = "publish_date";
    private static final String DUE_DATE = "due_date";
    private static final String START_DATE = "start_date";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //Creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + FEE_COL + " TEXT,"
                + BRANCH_COL + " TEXT,"
                + DURATION_COL + " TEXT,"
                + PUBLISH_COL + " TEXT,"
                + DUE_DATE + " TEXT,"
                + START_DATE + " TEXT)";
        db.execSQL(query);
        Log.d("DBTest", "Database and Table created.");
    }

    public void addNewCourse(String courseName, String courseFee, String branches, String courseDuration, String publishDate, String dueDate, String endDate) {

        //Creating a variable for write to the DB
        SQLiteDatabase db = this.getWritableDatabase();

        //Save variables in content values
        ContentValues course = new ContentValues();

        course.put(NAME_COL, courseName);
        course.put(FEE_COL, courseFee);
        course.put(BRANCH_COL, branches);
        course.put(DURATION_COL, courseDuration);
        course.put(PUBLISH_COL, publishDate);
        course.put(DUE_DATE, dueDate);
        course.put(START_DATE, endDate);

        //Passing the content value
        db.insert(TABLE_NAME, null, course);
        Log.d("DBTest", "Course added: " + courseName);
        db.close();
    }

    public String getCourseName() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{NAME_COL}, null, null, null, null, null);
        if (cursor != null && cursor.moveToNext()) {
            String courseName = cursor.getString(cursor.getColumnIndexOrThrow(NAME_COL));
            cursor.close();
            return courseName;
        }
        return null;
    }


    @Override
    //update database if there's an older version
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
}
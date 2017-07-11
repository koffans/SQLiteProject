package com.example.kof.sqliteproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by KOF on 7/11/2017.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREAT_BOOK = "create table Book(id integer primary key autoincrement,author text,price real,pages integer,name text)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_BOOK);
        Toast.makeText(mContext, "Created DataBase Successful!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

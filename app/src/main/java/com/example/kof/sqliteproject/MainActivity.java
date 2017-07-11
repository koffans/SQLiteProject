package com.example.kof.sqliteproject;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyDatabaseHelper DBHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper = new MyDatabaseHelper(this,"BookStore.db",null,1);
        db = DBHelper.getWritableDatabase();
        Button CreatDatabase = (Button) findViewById(R.id.CreatDatabase);
        CreatDatabase.setOnClickListener(this);
        Button InsertUsingSQL = (Button) findViewById(R.id.Insert_SQL);
        InsertUsingSQL.setOnClickListener(this);
        Button InsertUsingContentValues = (Button) findViewById(R.id.Insert_ContentValues);
        InsertUsingContentValues.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.CreatDatabase:
                DBHelper.getWritableDatabase();
                break;
            case R.id.Insert_SQL:
                db.execSQL("insert into Book(author,price,pages,name) values('Dan Brown',14.25,452,'The Lost Symbol')");

                Toast.makeText(this, "Insert Data Using SQL Statement", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Insert_ContentValues:
                ContentValues Values = new ContentValues();
                Values.put("author","Dan Brown");
                Values.put("price",14.32);
                Values.put("pages",456);
                Values.put("name","The Da Vinci Code");
                db.insert("Book",null, Values);
                Values.clear();
                Toast.makeText(this, "Insert Data Using ContentValues", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
    }
}

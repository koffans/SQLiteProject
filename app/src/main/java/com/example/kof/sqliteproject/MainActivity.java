package com.example.kof.sqliteproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper = new MyDatabaseHelper(this,"BookStore.db",null,1);
        Button CreatDatabase = (Button) findViewById(R.id.CreatDatabase);
        CreatDatabase.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        DBHelper.getWritableDatabase();
                    }
                }
        );
    }
}

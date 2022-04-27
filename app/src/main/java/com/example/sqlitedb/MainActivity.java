package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBhadnler handler =  new DBhadnler(this,"emdb",null,1);
        handler.ADDemployee(new Employee(10,"Sarthak Tiwari",45.67));
       handler.getEmployee(10);
        handler.close();

    }
}
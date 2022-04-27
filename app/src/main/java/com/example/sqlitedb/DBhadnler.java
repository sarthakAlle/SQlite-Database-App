package com.example.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBhadnler extends SQLiteOpenHelper {
    public DBhadnler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create= "CREATE TABLE myemployee(sno INTEGER PRIMARY KEY,name TEXT,increment TEXT)";
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop= String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(drop,new String[] {"myemployee"});
    }
    public  void ADDemployee(Employee emp){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name",emp.getName());
        contentValues.put("increment",emp.getIncrement());
        contentValues.put("Sno",emp.getSno());
        Long k=sqLiteDatabase.insert("myemployee",null,contentValues);
        Log.d("alletag",Long.toString(k));
        sqLiteDatabase.close();
    }
    public  void getEmployee(int Sno){
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.query("myemployee", new String[] {"Sno, name, increment"},
                "Sno=?",new String[]{String.valueOf(Sno)},null,null,null);
        if (cursor != null && cursor.moveToFirst()) {
            Log.d("alletag", cursor.getString(1));
            Log.d("alletag", cursor.getString(2));
        }
        else{
            Log.d("alletag","koi error aa gaya");
        }
    }
}

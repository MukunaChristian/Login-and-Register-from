package com.example.bookalot2.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OderHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public  static  final  String DATABASE_NAME = "ord.db";

    public OderHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_TABLE = "CREATE TABLE " + OderContact.OrderEntry.TABLE_NAME + "("
                + OderContact.OrderEntry._ID + " INTERGER PRIMARY KEY AUTOINCREMENT, "
                + OderContact.OrderEntry.COLUMN_NAME + "TEXT NOT NULL,"
                + OderContact.OrderEntry.COLUMN_PRICE + "TEXT NOT NULL);";

        sqLiteDatabase.execSQL(SQL_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

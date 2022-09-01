package com.example.bookalot2.Database;

import android.net.Uri;
import android.provider.BaseColumns;

public class OderContact {
    public OderContact() {

    }
    public static final String CONTENT_AUTHORITY = "com.example.bookalot2";
    public static  final  Uri BASE_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH = "oder";

    public static abstract class OrderEntry implements BaseColumns{
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI, PATH);

        public static  final String TABLE_NAME = "oder";
        public static  final  String _ID = BaseColumns._ID;
        public static  final  String COLUMN_NAME = "name";
        public static  final  String COLUMN_PRICE = "price";
//        public static  final  String COLUMN_NAME = "name";
//        public static  final  String COLUMN_NAME = "name";
//        public static  final  String COLUMN_NAME = "name";

    }
}

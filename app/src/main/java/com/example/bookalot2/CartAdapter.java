package com.example.bookalot2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.bookalot2.Database.OderContact;

public class CartAdapter extends CursorAdapter {
    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cart, parent, false );
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        //getting the views;
        TextView bookname, price;

        bookname = view.findViewById(R.id.bookNameinOrderSummary);
        price = view.findViewById(R.id.priceinOrderSummary);



        int name = cursor.getColumnIndex(OderContact.OrderEntry.COLUMN_NAME);
        int priceofbook =  cursor.getColumnIndex(OderContact.OrderEntry.COLUMN_PRICE);

        String bookOfName =  cursor.getString(name);
        String bookofPrice = cursor.getString(priceofbook);

        bookname.setText(name);
        price.setText(bookofPrice);


    }
}

package com.example.bookalot2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookalot2.Database.OderContact;

public class infoActivity extends AppCompatActivity implements  LoaderManager.LoaderCallbacks<Cursor>{
    ImageView imageView;
    Button addtocart;
    TextView bookfPrice, bookname1, addnew, addold, quantinumber,plus, less;
    int quantity;
    public Uri mCurrrrentCartUri;
    boolean hasAllRequiredvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        bookfPrice =  findViewById(R.id.bookPrice);
        bookname1 =  findViewById(R.id.bookName);
        addnew = findViewById(R.id.txtnew);
        addold = findViewById(R.id.addold);
        quantinumber = findViewById(R.id.quantity);
        plus = findViewById(R.id.addqu);
        less =  findViewById(R.id.less);
        imageView= findViewById(R.id.imageViewInfo);
        addtocart = findViewById(R.id.addtocart);

//       bookname1.setText("Python");

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bprice = 500;
                quantity++;
                displayQuantity();
                int bbprice = bprice *quantity;
                String setnewPrice = String.valueOf(bbprice);
                bookfPrice.setText(setnewPrice);
            }
        });

        less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bprice = 500;
                if (quantity == 0){
                    Toast.makeText(infoActivity.this, "can't decresse quantity <0", Toast.LENGTH_SHORT).show();
                }else {
                    quantity--;
                    displayQuantity();
                    int bbprice = bprice *quantity;
                    String setnewPrice = String.valueOf(bbprice);
                    bookfPrice.setText(setnewPrice);
                }
            }
        });
       addtocart.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                Intent intent = new Intent(infoActivity.this, SummaryActivity.class);
                startActivity(intent);

                saveCart();
            }
        });


    }

    private void displayQuantity() {
        quantinumber.setText(String.valueOf(quantity));
    }

    private boolean saveCart() {
        // getting the value from our views
        String name = bookname1.getText().toString();
        String price = bookfPrice.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OderContact.OrderEntry.COLUMN_PRICE, name);
        values.put(OderContact.OrderEntry.COLUMN_PRICE, price);


        if (mCurrrrentCartUri == null){
            Uri newUri = getContentResolver().insert(OderContact.OrderEntry.CONTENT_URI,values);
            if (newUri == null){
                Toast.makeText(this, "Failled to add cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Successs adding to car", Toast.LENGTH_SHORT).show();
            }
        }

        hasAllRequiredvalue = true;
        return hasAllRequiredvalue;

    }



    @Override
    public Loader<Cursor> onCreateLoader(int id,  Bundle args) {
        String[] projection = {OderContact.OrderEntry._ID,
        OderContact.OrderEntry.COLUMN_NAME,
        OderContact.OrderEntry.COLUMN_PRICE
        };

        return new CursorLoader(this, mCurrrrentCartUri,
                projection,null,null,null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
          if (cursor == null || cursor.getCount() <1){
              return;
          }
          if(cursor.moveToFirst()){
              int name = cursor.getColumnIndex(OderContact.OrderEntry.COLUMN_NAME);
              int price =  cursor.getColumnIndex(OderContact.OrderEntry.COLUMN_PRICE);

              String bookofName =  cursor.getString(name);
              String bookofPrice = cursor.getString(price);

              bookname1.setText(bookofName);
              bookfPrice.setText(bookofPrice);
          }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

        bookname1.setText("");
        bookfPrice.setText("");

    }
}
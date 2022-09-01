package com.example.bookalot2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.example.bookalot2.Database.OderContact;

public class SummaryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public CartAdapter cartAdapter;
    public static  final int LOADER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

       // getLoaderManager().initLoader(LOADER, null, this);

        ListView listView = findViewById(R.id.list);
        cartAdapter =  new CartAdapter(this,null);
        listView.setAdapter(cartAdapter);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OderContact.OrderEntry._ID,
                OderContact.OrderEntry.COLUMN_NAME,
                OderContact.OrderEntry.COLUMN_PRICE
        };

        return new CursorLoader(this, OderContact.OrderEntry.CONTENT_URI,
                projection,null,null,null);
    }


    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        cartAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset( Loader<Cursor> loader) {
        cartAdapter.swapCursor(null);


    }
}
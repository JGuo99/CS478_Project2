package com.example.project2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DealerListActivity extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the ID of the image to display and set it as the image for this ImageView
//        imageView.setImageResource(intent.getIntExtra(MainActivity.EXTRA_RES_ID, 0));
        Intent intent = getIntent();
        int dealerName = intent.getIntExtra(MainActivity.EXTRA_LIST_ID, 0);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.dealer_list, getResources().getStringArray(dealerName)));

        // getListView() retrieves the ListView generated automatically by
        // ListActivity
        ListView lv = getListView();

        // Enable filtering by list items when the user types in the virtual keyboard
        lv.setTextFilterEnabled(true);

    }
}
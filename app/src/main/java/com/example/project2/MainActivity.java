package com.example.project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    protected static final String EXTRA_RES_ID = "Image_ID";
    protected static final String EXTRA_LIST_ID = "Dealer_ID";

    private ArrayList<Integer> lowResThumbIds = new ArrayList<>(
            Arrays.asList(R.drawable.image1_thumb, R.drawable.image2_thumb,
                    R.drawable.image3_thumb, R.drawable.image4_thumb, R.drawable.image5_thumb,
                    R.drawable.image6_thumb));

    private ArrayList<String> mCarNames = new ArrayList<>(
            Arrays.asList("Mazda 3", "Audi RS7", "Mercedes G Wagon",
                    "Aston Martin Vantage", "Toyota Prius", "Nissan Cube"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridV = (GridView) findViewById(R.id.gridview);
        gridV.setAdapter(new ImageAdapter(this, lowResThumbIds, mCarNames));    // This talks to the ImageAdapter class

        gridV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
                intent.putExtra(EXTRA_RES_ID, (int) pos);
                startActivity(intent);
            }
        });

        registerForContextMenu(gridV);
    }


    public void toWebsite(String web) {
        Uri webpage = Uri.parse(web);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        try {
            startActivity(webIntent);
        }catch (Exception e){
            Log.e("TAG", e.toString());
        }
    }

    public void toFullImage(int id) {
        Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
        intent.putExtra(EXTRA_RES_ID, (int) id);
        startActivity(intent);
    }

    public void toDealerList(int dealerships) {
        Intent intent = new Intent(MainActivity.this, DealerListActivity.class);
        intent.putExtra(EXTRA_LIST_ID, dealerships);
        startActivity(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // Testing . . .
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        int pos = info.position;
        // End . . .

        switch (pos) { //This should allow to chose different menus
            case 0:
                getMenuInflater().inflate(R.menu.menu0, menu);
                break;
            case 1:
                getMenuInflater().inflate(R.menu.menu1, menu);
                break;
            case 2:
                getMenuInflater().inflate(R.menu.menu2, menu);
                break;
            case 3:
                getMenuInflater().inflate(R.menu.menu3, menu);
                break;
            case 4:
                getMenuInflater().inflate(R.menu.menu4, menu);
                break;
            case 5:
                getMenuInflater().inflate(R.menu.menu5, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int dealerships;
        switch (item.getItemId()) {
            case R.id.full_image_option_0:
                toFullImage(0);
                return true;
            case R.id.webpage_option_0:
                toWebsite("https://www.mazdausa.com/vehicles/2020-mazda3-hatchback");
                return true;
            case R.id.list_option_0:
                dealerships = R.array.mazda_dealerships;
                toDealerList(dealerships);
                return true;

            case R.id.full_image_option_1:
                toFullImage(1);
                return true;
            case R.id.webpage_option_1:
                toWebsite("https://www.audiusa.com/us/web/en/models/a7/rs7/2021/overview.html");
                return true;
            case R.id.list_option_1:
                dealerships = R.array.audi_dealerships;
                toDealerList(dealerships);
                return true;

            case R.id.full_image_option_2:
                toFullImage(2);
                return true;
            case R.id.webpage_option_2:
                toWebsite("https://www.mbusa.com/en/vehicles/class/g-class/suv");
                return true;
            case R.id.list_option_2:
                dealerships = R.array.mercedes_dealerships;
                toDealerList(dealerships);
                return true;

            case R.id.full_image_option_3:
                toFullImage(3);
                return true;
            case R.id.webpage_option_3:
                toWebsite("https://www.astonmartin.com/en-us/models/new-vantage");
                return true;
            case R.id.list_option_3:
                dealerships = R.array.aston_dealerships;
                toDealerList(dealerships);
                return true;

            case R.id.full_image_option_4:
                toFullImage(4);
                return true;
            case R.id.webpage_option_4:
                toWebsite("https://www.toyota.com/prius/");
                return true;
            case R.id.list_option_4:
                dealerships = R.array.toyota_dealerships;
                toDealerList(dealerships);
                return true;

            case R.id.full_image_option_5:
                toFullImage(5);
                return true;
            case R.id.webpage_option_5:
                toWebsite("https://www.nissanusa.com/vehicles/discontinued/cube.html");
                return true;
            case R.id.list_option_5:
                dealerships = R.array.nissan_dealerships;
                toDealerList(dealerships);
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}
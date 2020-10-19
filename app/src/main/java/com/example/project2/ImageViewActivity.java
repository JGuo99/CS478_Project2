package com.example.project2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

public class ImageViewActivity extends Activity {
    ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Get the Intent used to start this Activity
        Intent intent = getIntent();

        // Make a new ImageView
        // Example of programmatic layout definition
        imageView = new ImageView(getApplicationContext());


        // Get the ID of the image to display and set it as the image for this ImageView
        int i;
        i = intent.getIntExtra(MainActivity.EXTRA_RES_ID, 0);
        Log.i("From IVA", String.format("Value of i is: %d", i));

        // Webpage
        Uri webpage = Uri.parse("https://www.android.com"); //Only for initializing


        //Check which full resolution image to display
        switch (i) {
            case 0:
                imageView.setImageResource(R.drawable.image1);
                webpage = Uri.parse("https://www.mazdausa.com/vehicles/2020-mazda3-hatchback");
                break;
            case 1:
                imageView.setImageResource(R.drawable.image2);
                webpage = Uri.parse("https://www.audiusa.com/us/web/en/models/a7/rs7/2021/overview.html");
                break;
            case 2:
                imageView.setImageResource(R.drawable.image3);
                webpage = Uri.parse("https://www.mbusa.com/en/vehicles/class/g-class/suv");
                break;
            case 3:
                imageView.setImageResource(R.drawable.image4);
                webpage = Uri.parse("https://www.astonmartin.com/en-us/models/new-vantage");
                break;
            case 4:
                imageView.setImageResource(R.drawable.image5);
                webpage = Uri.parse("https://www.toyota.com/prius/");
                break;
            case 5:
                imageView.setImageResource(R.drawable.image6);
                webpage = Uri.parse("https://www.nissanusa.com/vehicles/discontinued/cube.html");
                break;
        }
        setContentView(imageView);

        final Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(webIntent);
                    imageView = null;
                    finish();
                }catch (Exception e){
                    Log.e("TAG", e.toString());
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        imageView = null;
        finish(); //Make sure ImageViewActivity is destroy after pressing back button!
    }
}

package com.mazouzi.trendingRepos.activities;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.mazouzi.trendingRepos.listitemviewdemo.R;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by high---tech on 13/01/2018.
 */

public class test_Activity extends Activity {

    RelativeLayout l=null;
    ImageView iv=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        iv=(ImageView)findViewById(R.id.image_test);
        Picasso.with(getApplicationContext())  //Here, this is context.
                .load("http://i.imgur.com/DvpvklR.png")  //Url of the image to load.
                .into(iv);


    }
}

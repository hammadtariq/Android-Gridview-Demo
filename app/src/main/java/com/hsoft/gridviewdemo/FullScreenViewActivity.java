package com.hsoft.gridviewdemo;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.hsoft.gridviewdemo.info.androidhive.imageslider.adapter.FullScreenImageAdapter;
import com.hsoft.gridviewdemo.info.androidhive.imageslider.helper.Utils;


public class FullScreenViewActivity extends ActionBarActivity {

    private Utils utils;
    private FullScreenImageAdapter adapter;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_view);

        viewPager = (ViewPager) findViewById(R.id.pager);

        utils = new Utils(getApplicationContext());

        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);

        adapter = new FullScreenImageAdapter(FullScreenViewActivity.this,
                utils.getFilePaths());

        viewPager.setAdapter(adapter);

        // displaying selected image first
        viewPager.setCurrentItem(position);

    }

}

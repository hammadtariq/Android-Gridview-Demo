package com.hsoft.gridviewdemo.info.androidhive.imageslider.adapter;

import com.hsoft.gridviewdemo.R;
import com.hsoft.gridviewdemo.info.androidhive.imageslider.helper.AppConstant;
import com.hsoft.gridviewdemo.info.androidhive.imageslider.helper.TouchImageView;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FullScreenImageAdapter extends PagerAdapter {

    private Activity _activity;
    private ArrayList<String> _imagePaths;
    private LayoutInflater inflater;
    Context context;

    // constructor
    public FullScreenImageAdapter(Activity activity,
                                  ArrayList<String> imagePaths) {
        this._activity = activity;
        this._imagePaths = imagePaths;
    }

    @Override
    public int getCount() {
        return this._imagePaths.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView imgDisplay;
        Button btnClose;
        final TextView txtMy;

        inflater = (LayoutInflater) _activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image, container,
                false);

        imgDisplay = (ImageView) viewLayout.findViewById(R.id.imgDisplay);
        btnClose = (Button) viewLayout.findViewById(R.id.btnClose);
        txtMy = (TextView) viewLayout.findViewById (R.id.txtMy);


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize  = 8;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = BitmapFactory.decodeFile(_imagePaths.get(position), options);
        imgDisplay.setImageBitmap(bitmap);

        File directory = new File(_imagePaths.get(position) );
        String name = directory.getName();
        txtMy.setText(name);



        // close button click event
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //_activity.finish();

                //txtMy.setText(_imagePaths.get(position));

                File directory = new File(_imagePaths.get(position) );
                String name = directory.getName();
                txtMy.setText(name);



            }
        });

        ((ViewPager) container).addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }

}

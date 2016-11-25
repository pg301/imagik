package com.example.root.fromgallery;

import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private Cursor cursor;
    private  int columnIndex;
    GridView AllImages;
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        String[] projection = {MediaStore.Images.Thumbnails._ID};
        cursor = managedQuery(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, projection, null, null, MediaStore.Images.Thumbnails._ID + "");
        columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Thumbnails._ID);

        AllImages = (GridView) findViewById(R.id.GV_Images);
        AllImageAdapter adapter = new AllImageAdapter(MainActivity.this,cursor,columnIndex);
        AllImages.setAdapter(adapter);
        //adapter.notifyDataSetChanged();


    }
}

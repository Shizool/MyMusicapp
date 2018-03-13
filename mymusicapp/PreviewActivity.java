package com.example.android.mymusicapp;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity{

    boolean songFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        String title = getIntent().getStringExtra("TITLE");
        String author = getIntent().getStringExtra("AUTHOR");
        int imageId = getIntent().getIntExtra("IMAGE",0);

        TextView name = (TextView) findViewById(R.id.preview_title);
        name.setText(title);

        TextView name2 = (TextView) findViewById(R.id.preview_author);
        name2.setText(author);

        ImageView cover = (ImageView) findViewById(R.id.preview_image);
        cover.setImageResource(imageId);

        final ImageView playPause = (ImageView) findViewById(R.id.preview_playpause);
        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(songFlag)
                {
                    playPause.setImageResource(R.drawable.play);
                    songFlag = false;
                }
                else
                {
                    playPause.setImageResource(R.drawable.pause);
                    songFlag = true;
                }
            }
        });

    }
}

package com.example.android.mymusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class PreviewActivity extends AppCompatActivity implements Serializable{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        Intent i = getIntent();
        ArrayList<Song> songs = (ArrayList<Song>) i.getSerializableExtra("songArray");

    }
}

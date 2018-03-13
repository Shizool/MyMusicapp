package com.example.android.mymusicapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    boolean songFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("The intro", "xx", R.drawable.xx));
        songs.add(new Song("Everybody", "Logic", R.drawable.everybody1));
        songs.add(new Song("Rockstar", "Post Malone", R.drawable.rockstar));
        songs.add(new Song("Narcos", "Migos", R.drawable.narcos));
        songs.add(new Song("Havana", "Camila Cabello", R.drawable.havana));
        songs.add(new Song("Don't", "Ed Sheeran", R.drawable.dont));
        songs.add(new Song("Fade Away", "Logic", R.drawable.fadeaway));
        songs.add(new Song("Thunder", "Imagine Dragons", R.drawable.thunder));
        songs.add(new Song("Shape of you", "Ed Sheeran", R.drawable.shapeofyou));
        songs.add(new Song("Sweater Weather", "The Neighbourhood", R.drawable.sweaterwheather));
        songs.add(new Song("Be mine", "Ofenbach", R.drawable.bemine));
        songs.add(new Song("Ciao adios", "Anne-Marie", R.drawable.ciao));
        songs.add(new Song("Closer", "The Chainsmokers", R.drawable.closer));
        songs.add(new Song("Human", "Rag'n'Bone Man", R.drawable.human));
        songs.add(new Song("Without me", "Eminem", R.drawable.withoutme));

        final SongAdapter adapter = new SongAdapter(this, songs);

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

                for(int x = 0; x < songs.size(); x++)
                {
                    songs.get(x).setIsSelected(false);
                }

                songs.get(i).setIsSelected(true);
                adapter.notifyDataSetChanged();

                songFlag = true;
                songPlaying();

                final String pTitle = songs.get(i).getSongTitle();
                final String pAuthor = songs.get(i).getAuthor();
                final int pImage = songs.get(i).getImageId();

                ImageView goPreview = (ImageView) findViewById(R.id.arrowPreview);
                goPreview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        Intent i = new Intent(MainActivity.this, PreviewActivity.class);
                        i.putExtra("TITLE", pTitle);
                        i.putExtra("AUTHOR", pAuthor);
                        i.putExtra("IMAGE", pImage);
                        startActivity(i);
                    }} );



                ImageView goLyrics = (ImageView) view.findViewById(R.id.lyrics);
                goLyrics.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        Intent i = new Intent(MainActivity.this, LyricsActivity.class);
                        startActivity(i);
                    }} );
            }
        });

        final ImageView playPause = (ImageView) findViewById(R.id.play_pause);
        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(songFlag)
                    songFlag=false;
                else
                    songFlag=true;
               songPlaying();
            }} );

    }

    public void songPlaying()
    {
        ImageView v = findViewById(R.id.play_pause);
        if(songFlag)
            v.setImageResource(R.drawable.pause);
        else
            v.setImageResource(R.drawable.play);
    }
}

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

    View tmpView = null;

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

        SongAdapter adapter = new SongAdapter(this, songs);

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView t = (TextView) view.findViewById(R.id.title);
                TextView a = (TextView) view.findViewById(R.id.author);
                t.setTextColor(getResources().getColor(R.color.colorAccent));
                a.setTextColor(getResources().getColor(R.color.colorAccent));

                if(tmpView != null && tmpView != view) {
                    t = (TextView) tmpView.findViewById(R.id.title);
                    a = (TextView) tmpView.findViewById(R.id.author);
                    t.setTextColor(getResources().getColor(R.color.white));
                    a.setTextColor(getResources().getColor(R.color.white));
                }

                tmpView = view;
            }
        });

/*
        ImageView goPreview = (ImageView) findViewById(R.id.arrowPreview);
        goPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                Intent i = new Intent(MainActivity.this, PreviewActivity.class);
                i.putExtra("songArray", );
                startActivity(i);
            }} );
*/


    }
}

package com.example.android.mymusicapp;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song>{

    public SongAdapter (Activity context, ArrayList<Song> songs)
    {
        super (context, 0, songs);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;

        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
        }

        Song currentSong = getItem(position);

        ImageView previewView = (ImageView) listItemView.findViewById(R.id.preview);
        previewView.setImageResource(currentSong.getImageId());

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title);
        titleTextView.setText(currentSong.getSongTitle());

        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author);
        authorTextView.setText(currentSong.getAuthor());

        if(currentSong.getIsSelected())
        {
            titleTextView.setTextColor(ContextCompat.getColor(getContext(),R.color.colorAccent));
            authorTextView.setTextColor(ContextCompat.getColor(getContext(),R.color.colorAccent));
        }
        else
        {
            titleTextView.setTextColor(ContextCompat.getColor(getContext(),R.color.white));
            authorTextView.setTextColor(ContextCompat.getColor(getContext(),R.color.white));
        }

        return listItemView;
    }
}

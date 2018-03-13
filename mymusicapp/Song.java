package com.example.android.mymusicapp;

public class Song {

    private String mSongTitle;
    private String mAuthor;
    private int mImageId;
    private String mLyrics;
    private Boolean isSelected = false;

    public Song (String songTitle, String author, int ImageId)
    {
        mSongTitle = songTitle;
        mAuthor = author;
        mImageId = ImageId;
    }

    public Song (String songTitle, String author, int ImageId, String lyrics)
    {
        mSongTitle = songTitle;
        mAuthor = author;
        mImageId = ImageId;
        mLyrics = lyrics;
    }

    public String getSongTitle()
    {
        return mSongTitle;
    }

    public String getAuthor()
    {
        return mAuthor;
    }

    public int getImageId()
    {
        return mImageId;
    }

    public String getLyrics()
    {
        return mLyrics;
    }

    public void setIsSelected (boolean select)
    {
        this.isSelected = select;
    }

    public boolean getIsSelected() { return isSelected; }
}

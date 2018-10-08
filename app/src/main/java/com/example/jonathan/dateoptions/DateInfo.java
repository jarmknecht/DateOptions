package com.example.jonathan.dateoptions;

import android.media.Image;

public class DateInfo
{
    public String name;
    public int pic;
    public int rating;

    public DateInfo(String name, int pic, int rating)
    {
        this.name = name;
        this.pic = pic;
        this.rating = rating;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setPic(int pic)
    {
        this.pic = pic;
    }

    public int getPic()
    {
        return pic;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public int getRating()
    {
        return rating;
    }
}

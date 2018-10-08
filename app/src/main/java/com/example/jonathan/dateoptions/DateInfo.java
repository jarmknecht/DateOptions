package com.example.jonathan.dateoptions;

import android.media.Image;

public class DateInfo
{
    public String name;
    public Image pic;
    public int rating;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setPic(Image pic)
    {
        this.pic = pic;
    }

    public Image getPic()
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

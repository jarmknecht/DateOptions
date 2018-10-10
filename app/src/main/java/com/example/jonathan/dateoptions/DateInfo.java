package com.example.jonathan.dateoptions;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

public class DateInfo
{
    public String name;
    public int pic;
    public List<Integer> ratings;
    public double latitude;
    public double longitude;
    public int rating;

    public DateInfo(String name, int pic, double latitude, double longitude, List<Integer> ratings)
    {
        this.name = name;
        this.pic = pic;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ratings = ratings;
        setRating(ratings);
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

    public void setLatitude(double latitude) {this.latitude = latitude;}

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setRatings(List<Integer> ratings) {this.ratings = ratings;}

    public List<Integer> getRatings() {return ratings;}

    public void setRating(List<Integer> Ratings)
    {
        int total = 0;
        for(int i = 0; i < Ratings.size(); i++)
        {
            total += Ratings.get(i);
        }
        this.rating = total/Ratings.size();
    }

    public int getRating()
    {
        return rating;
    }
}

package com.example.jonathan.dateoptions;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

public class DateInfo
{
    public String name;
    public int pic;
    public int map_pic;
    public List<Integer> ratings;
    public double rating;

    public DateInfo(String name, int pic, int map_pic, List<Integer> ratings)
    {
        this.name = name;
        this.pic = pic;
        this.map_pic = map_pic;
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

    public void setMap_pic(int map_pic) {this.map_pic = map_pic;}

    public int getMap_pic() {return map_pic;}

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

    public double getRating()
    {
        return rating;
    }
}

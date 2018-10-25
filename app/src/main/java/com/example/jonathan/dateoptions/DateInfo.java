package com.example.jonathan.dateoptions;


import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class DateInfo implements Serializable
{
    public String name;
    public int pic;
    public List<Integer> ratings;
    public double latitude;
    public double longitude;
    public int rating;
    public String description;
    public List<String> reviews;

    public DateInfo(String name, int pic, double latitude, double longitude, List<Integer> ratings, String description, List<String> reviews)
    {
        this.name = name;
        this.pic = pic;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ratings = ratings;
        this.description = description;
        this.reviews = reviews;
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

    public void setRating(List<Integer> ratings)
    {
        int total = 0;
        for(int i = 0; i < ratings.size(); i++)
        {
            total += ratings.get(i);
        }
        this.rating = total/ratings.size();
    }

    public void addRating(int rating)
    {
        ratings.add(rating);
        setRating(ratings);
    }

    public int getRating()
    {
        return rating;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setReviews(List<String> reviews)
    {
        this.reviews = reviews;
    }

    public List<String> getReviews()
    {
        return reviews;
    }

    public void addReview(String review)
    {
        reviews.add(review);
    }
}

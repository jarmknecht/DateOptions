package com.example.jonathan.dateoptions;


import android.media.Rating;

import java.util.ArrayList;
import java.util.List;

public class DateApp {
    public static DateApp dA;
    private List<DateInfo> dates;

    private DateApp()
    {
        dates = new ArrayList<DateInfo>();
    }

    public static DateApp getInstance()
    {
        if(dA == null)
        {
            dA = new DateApp();
        }
        return dA;
    }

    public void setDates(List<DateInfo> dates)
    {
        this.dates = dates;
    }

    public List<DateInfo> getDates()
    {
        return dates;
    }

    public void initializeData()
    {
        List<Integer> Ratings1 = new ArrayList<Integer>();
        Ratings1.add(4);
        Ratings1.add(3);
        Ratings1.add(5);
        Ratings1.add(5);
        Ratings1.add(4);
        Ratings1.add(1);
        List<Integer> Ratings2 = new ArrayList<Integer>();
        Ratings2.add(4);
        Ratings2.add(5);
        Ratings2.add(5);
        Ratings2.add(5);
        Ratings2.add(4);
        Ratings2.add(5);
        List<Integer> Ratings3 = new ArrayList<Integer>();
        Ratings3.add(2);
        Ratings3.add(1);
        Ratings3.add(1);
        Ratings3.add(2);
        Ratings3.add(2);
        Ratings3.add(1);
        String review1 = "Nice place";
        String review2 = "10/10";
        String review3 = "Awful";
        String review4 = "Horrible";
        List<String> reviews1 = new ArrayList<>();
        List<String> reviews2 = new ArrayList<>();
        reviews1.add(review1);
        reviews1.add(review2);
        reviews2.add(review3);
        reviews2.add(review4);
        this.dates.add(new DateInfo("Benihana", R.drawable.bennihana, 40.766094, -111.893054, Ratings3, "Japanese Hibachi Grill", reviews1));
        this.dates.add(new DateInfo("Bonneville Shoreline Hike", R.drawable.bonneville_shoreline_pic, 40.955939, -111.877, Ratings2, "Great Views of the Valley", reviews1));
        this.dates.add(new DateInfo("Boondocks", R.drawable.boondocks, 40.494744,-111.888872, Ratings2, "Family Fun Center", reviews1));
        this.dates.add(new DateInfo("Brick Oven", R.drawable.brickoven, 40.244566, -111.656290, Ratings2, "Gourmet Pizza", reviews1));
        this.dates.add(new DateInfo("BYU Bowling", R.drawable.byubowling, 40.248542, -111.646504, Ratings1, "Bowling and Arcade Games", reviews1));
        this.dates.add(new DateInfo("BYU Creamery", R.drawable.byucreamery, 40.250212, -111.643305, Ratings3, "Campus Ice Cream Shop", reviews1));
        this.dates.add(new DateInfo("BYU Museum of Art", R.drawable.byumoa, 40.250880, -111.647951, Ratings3, "Features a Wide Range of Art", reviews1));
        this.dates.add(new DateInfo("BYU Tennis Courts", R.drawable.tenniscourts, 40.245712, -111.655190, Ratings3, "Campus Tennis Courts", reviews1));
        this.dates.add(new DateInfo("Chip Cookies", R.drawable.chipcookies, 40.240393, -111.661466, Ratings2, "Cookies and Desserts", reviews1));
        this.dates.add(new DateInfo("City Creek Center", R.drawable.citycreek, 40.768448, -111.891859, Ratings1, "Shopping and Dinning Areas", reviews1));
        this.dates.add(new DateInfo("Color Me Mine", R.drawable.colormemine, 40.301466, -111.657655, Ratings2, "Paint Pottery and Take It Home", reviews1));
        this.dates.add(new DateInfo("Fat Cats", R.drawable.fatcats, 40.250134, -111.657745, Ratings2, "Bowling and Costa Vida", reviews1));
        this.dates.add(new DateInfo("Gallivan Center", R.drawable.gallivan_center, 40.764713, -111.889556, Ratings1, "Outdoor Concert and Ice Rink", reviews1));
        this.dates.add(new DateInfo("Getout Games", R.drawable.getoutgames, 40.237622, -111.659088, Ratings1, "Live Escape Rooms", reviews1));
        this.dates.add(new DateInfo("Harris Fine Arts Center", R.drawable.hfacexterior, 40.250073, -111.648090, Ratings2, "A Place For Plays and Concerts", reviews1));
        this.dates.add(new DateInfo("Hogle Zoo", R.drawable.hoglezoo, 40.750466, -111.814103, Ratings2, "Fun Place for All Ages", reviews1));
        this.dates.add(new DateInfo("Kiwanis Park", R.drawable.kiwanispark, 40.247078, -111.639731, Ratings1, "Big Park That Has Many Fun Options", reviews1));
        this.dates.add(new DateInfo("Laser Assault", R.drawable.laserassault, 40.237359, -111.660082, Ratings3, "Laser Tag", reviews1));
        this.dates.add(new DateInfo("LaVell Edwards Stadium", R.drawable.byustadium, 40.257529, -111.654524, Ratings3, "BYU Football", reviews1));
        this.dates.add(new DateInfo("Lowes Xtreme Air Sports", R.drawable.lowesxtreme, 40.232232, -111.678297, Ratings3, "High Flying Fun", reviews2));
        this.dates.add(new DateInfo("Megaplex Legacy Crossing", R.drawable.megaplexlegacy, 40.920684, -111.893080, Ratings2, "Stadium Seating Movie Theater", reviews1));
        this.dates.add(new DateInfo("Natural History Museum", R.drawable.naturalhistorymuseum, 40.764362, -111.822648, Ratings1, "Explore Earth Science", reviews1));
        this.dates.add(new DateInfo("Nielsen's Grove Park", R.drawable.nielsen_spark, 40.262180, -111.703240, Ratings3, "Picnic Areas and Pond", reviews1));
        this.dates.add(new DateInfo("Olive Garden", R.drawable.olivegarden, 40.764900, -111.893547, Ratings2, "Italian Food", reviews1));
        this.dates.add(new DateInfo("Outlets at Traverse Mountain", R.drawable.outletstraverse, 40.435381, -111.884338, Ratings3, "Outdoor Shopping Center", reviews1));
        this.dates.add(new DateInfo("Provo Canyon", R.drawable.provocanyon, 40.328981, -111.633928, Ratings1, "Scenic Hiking Trails", reviews1));
        this.dates.add(new DateInfo("Red Robin", R.drawable.redrobin, 40.741178, -111.826279, Ratings1, "Gourmet Burgers", reviews1));
        this.dates.add(new DateInfo("Rockwell Ice Cream", R.drawable.rockwell, 40.234480, -111.659131, Ratings1, "Old Fashioned Ice Cream", reviews1));
        this.dates.add(new DateInfo("South Davis Recreation Center", R.drawable.southdavisrec, 40.895560, -111.883578, Ratings3, "Recreational Center with Many Activities", reviews1));
        this.dates.add(new DateInfo("Sundance", R.drawable.sundance, 40.391538,  -111.577822, Ratings1, "Skiing Resort and Lodging", reviews1));
        this.dates.add(new DateInfo("Temple Square", R.drawable.templesquare, 40.770442, -111.892394, Ratings1, "Church Site and Visitor Center", reviews1));
        this.dates.add(new DateInfo("The Leonardo Museum", R.drawable.leonardo, 40.758992, -111.884803, Ratings1, "Science and Art Museum", reviews1));
        this.dates.add(new DateInfo("This is the Place Park", R.drawable.thisistheplace, 40.752815, -111.815919, Ratings3, "Church History Site", reviews1));
        this.dates.add(new DateInfo("Wynnsong Movie Theater", R.drawable.wynnsong, 40.299727, -111.660419, Ratings3, "Discounted Theater for Students", reviews1));
    }
}

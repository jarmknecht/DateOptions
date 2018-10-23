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
        this.dates.add(new DateInfo("Benihana", R.drawable.bennihana, 40.766094, -111.893054, Ratings3, "A date place"));
        this.dates.add(new DateInfo("Bonneville Shoreline Hike", R.drawable.bonneville_shoreline_pic, 40.955939, -111.877, Ratings2, "Go hiking"));
        this.dates.add(new DateInfo("Boondocks", R.drawable.boondocks, 40.494744,-111.888872, Ratings2, "Boondock Saints is a good movie"));
        this.dates.add(new DateInfo("Brick Oven", R.drawable.brickoven, 40.244566, -111.656290, Ratings2, "Expensive pizza"));
        this.dates.add(new DateInfo("BYU Bowling", R.drawable.byubowling, 40.248542, -111.646504, Ratings1, "Cheap bowling"));
        this.dates.add(new DateInfo("BYU Creamery", R.drawable.byucreamery, 40.250212, -111.643305, Ratings3, "Overhyped ice cream"));
        this.dates.add(new DateInfo("BYU Museum of Art", R.drawable.byumoa, 40.250880, -111.647951, Ratings3, "Come look at paintings of Jesus"));
        this.dates.add(new DateInfo("BYU Tennis Courts", R.drawable.tenniscourts, 40.245712, -111.655190, Ratings3, "Come hit some balls"));
        this.dates.add(new DateInfo("Chip Cookies", R.drawable.chipcookies, 40.240393, -111.661466, Ratings2, "In case your too lazy to make your own"));
        this.dates.add(new DateInfo("City Creek Center", R.drawable.citycreek, 40.768448, -111.891859, Ratings1, "A date place"));
        this.dates.add(new DateInfo("Color Me Mine", R.drawable.colormemine, 40.301466, -111.657655, Ratings2, "Is this an art place?"));
        this.dates.add(new DateInfo("Fat Cats", R.drawable.fatcats, 40.250134, -111.657745, Ratings2, "Bowling AND Costa Vida. 10/10"));
        this.dates.add(new DateInfo("Gallivan Center", R.drawable.gallivan_center, 40.764713, -111.889556, Ratings1, "Sounds pretentious"));
        this.dates.add(new DateInfo("Getout Games", R.drawable.getoutgames, 40.237622, -111.659088, Ratings1, "The newest fad. Will be out of buisness in 2 years"));
        this.dates.add(new DateInfo("Harris Fine Arts Center", R.drawable.hfacexterior, 40.250073, -111.648090, Ratings2, "For all of the creative students who will be working at Starbucks when they graduate"));
        this.dates.add(new DateInfo("Hogle Zoo", R.drawable.hoglezoo, 40.750466, -111.814103, Ratings2, "Don't feed the animals"));
        this.dates.add(new DateInfo("Kiwanis Park", R.drawable.kiwanispark, 40.247078, -111.639731, Ratings1, "For those weirdos who like being outside"));
        this.dates.add(new DateInfo("Laser Assault", R.drawable.laserassault, 40.237359, -111.660082, Ratings3, "Laser tag aka the best option on this list"));
        this.dates.add(new DateInfo("LaVell Edwards Stadium", R.drawable.byustadium, 40.257529, -111.654524, Ratings3, "Come watch BYU repeatedly fail at football"));
        this.dates.add(new DateInfo("Lowes Xtreme Air Sports", R.drawable.lowesxtreme, 40.232232, -111.678297, Ratings3, "NEVER GO HERE EVER!"));
        this.dates.add(new DateInfo("Megaplex Legacy Crossing", R.drawable.megaplexlegacy, 40.920684, -111.893080, Ratings2, "Generic date option 47"));
        this.dates.add(new DateInfo("Natural History Museum", R.drawable.naturalhistorymuseum, 40.764362, -111.822648, Ratings1, "Do you not want a second date"));
        this.dates.add(new DateInfo("Nielsen's Grove Park", R.drawable.nielsen_spark, 40.262180, -111.703240, Ratings3, "Another park"));
        this.dates.add(new DateInfo("Olive Garden", R.drawable.olivegarden, 40.764900, -111.893547, Ratings2, "There are much better restaurants"));
        this.dates.add(new DateInfo("Outlets at Traverse Mountain", R.drawable.outletstraverse, 40.435381, -111.884338, Ratings3, "Shopping time"));
        this.dates.add(new DateInfo("Provo Canyon", R.drawable.provocanyon, 40.328981, -111.633928, Ratings1, "Don't fall in"));
        this.dates.add(new DateInfo("Red Robin", R.drawable.redrobin, 40.741178, -111.826279, Ratings1, "Overpriced Five Guys"));
        this.dates.add(new DateInfo("Rockwell Ice Cream", R.drawable.rockwell, 40.234480, -111.659131, Ratings1, "Probably better than the Creamery"));
        this.dates.add(new DateInfo("South Davis Recreation Center", R.drawable.southdavisrec, 40.895560, -111.883578, Ratings3, "Outdoors activities without the outdoors"));
        this.dates.add(new DateInfo("Sundance", R.drawable.sundance, 40.391538,  -111.577822, Ratings1, "Check out the indie films"));
        this.dates.add(new DateInfo("Temple Square", R.drawable.templesquare, 40.770442, -111.892394, Ratings1, "Thats a lot of Jesus"));
        this.dates.add(new DateInfo("The Leonardo Museum", R.drawable.leonardo, 40.758992, -111.884803, Ratings1, "For the sophisticated"));
        this.dates.add(new DateInfo("This is the Place Park", R.drawable.thisistheplace, 40.752815, -111.815919, Ratings3, "I suppose this is a place"));
        this.dates.add(new DateInfo("Wynnsong Movie Theater", R.drawable.wynnsong, 40.299727, -111.660419, Ratings3, "Just another theater"));
    }
}

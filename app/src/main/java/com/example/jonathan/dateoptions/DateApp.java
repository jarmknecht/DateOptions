package com.example.jonathan.dateoptions;

import java.util.ArrayList;
import java.util.List;

public class DateApp
{
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
        this.dates.add(new DateInfo("BYU Bowling", R.drawable.byubowling, R.drawable.brickoven, Ratings1));
        this.dates.add(new DateInfo("BYU Creamery", R.drawable.byucreamery, R.drawable.byumoa, Ratings3));
        this.dates.add(new DateInfo("Chip Cookies", R.drawable.chipcookies, R.drawable.byustadium, Ratings2));
        this.dates.add(new DateInfo("Fat Cats", R.drawable.fatcats, R.drawable.citycreek, Ratings2));
        this.dates.add(new DateInfo("Getout Games", R.drawable.getoutgames, R.drawable.colormemine, Ratings1));
        this.dates.add(new DateInfo("Laser Assault", R.drawable.laserassault, R.drawable.gallivan_center, Ratings3));
        this.dates.add(new DateInfo("Provo Canyon", R.drawable.provocanyon, R.drawable.hfacexterior, Ratings1));
    }
}

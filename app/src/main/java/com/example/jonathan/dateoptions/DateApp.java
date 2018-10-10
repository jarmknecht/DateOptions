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
        this.dates.add(new DateInfo("BYU Bowling", R.drawable.byubowling, 40.247078, -111.639731, Ratings1));
        this.dates.add(new DateInfo("BYU Creamery", R.drawable.byucreamery, 40.250880, -111.639731, Ratings3));
        this.dates.add(new DateInfo("Chip Cookies", R.drawable.chipcookies, 40.240393, -111.660082, Ratings2));
        this.dates.add(new DateInfo("Fat Cats", R.drawable.fatcats, 40.250134, -111.657745, Ratings2));
        this.dates.add(new DateInfo("Getout Games", R.drawable.getoutgames, 40.237622, -111.659131, Ratings1));
        this.dates.add(new DateInfo("Laser Assault", R.drawable.laserassault, 40.237359, -111.660082, Ratings3));
        this.dates.add(new DateInfo("Provo Canyon", R.drawable.provocanyon, 40.328981, -111.633928, Ratings1));
    }
}

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
        this.dates.add(new DateInfo("BYU Bowling", R.drawable.byubowling, 4));
        this.dates.add(new DateInfo("BYU Creamery", R.drawable.byucreamery, 5));
        this.dates.add(new DateInfo("Chip Cookies", R.drawable.chipcookies, 4));
        this.dates.add(new DateInfo("Fat Cats", R.drawable.fatcats, 3));
        this.dates.add(new DateInfo("Get Out Games", R.drawable.getoutgames, 5));
        this.dates.add(new DateInfo("Laser Assault", R.drawable.laserassault, 5));
        this.dates.add(new DateInfo("Provo Canyon", R.drawable.provocanyon, 4));
    }
}

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
}

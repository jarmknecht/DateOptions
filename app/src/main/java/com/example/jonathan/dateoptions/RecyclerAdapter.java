package com.example.jonathan.dateoptions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DateViewHolder> {
    private List<DateInfo> dateList;

    public RecyclerAdapter(List<DateInfo> dateList) {
        this.dateList = dateList;
    }

    @Override
    public void onBindViewHolder(DateViewHolder dateViewHolder, int i) {
        DateInfo date = dateList.get(i);
        //set the photo name and reviews
    }

    @Override
    public DateViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //View itemView = LayoutInflater.
              //  from(viewGroup.getContext()).inflate(R.layout.card_layout,
               // viewGroup, false);

        //return new DateViewHolder(itemView);
        return null;
    }

    public static class DateViewHolder extends RecyclerView.ViewHolder {
        protected ImageView image;
        protected TextView name;


        public DateViewHolder(View v) {
            super(v);

        }
    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }

}

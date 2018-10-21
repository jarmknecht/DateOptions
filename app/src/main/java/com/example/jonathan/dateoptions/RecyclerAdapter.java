package com.example.jonathan.dateoptions;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DateViewHolder> {

    private List<DateInfo> dateList;

    public RecyclerAdapter() {
        this.dateList = DateApp.getInstance().getDates();
    }

    public RecyclerAdapter(List<DateInfo> infoList) {
        this.dateList = infoList;
    }

    @Override //Sets the values for the card view from the data Dakota is including
    public void onBindViewHolder(DateViewHolder dateViewHolder, int i) {
        dateViewHolder.image.setImageResource(dateList.get(i).pic);
        dateViewHolder.name.setText(dateList.get(i).name);
        //dateViewHolder.rating.setNumStars(dateList.get(i).rating);
        dateViewHolder.rating.setRating(dateList.get(i).rating);
        dateViewHolder.date = dateList.get(i);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public DateViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
               from(viewGroup.getContext()).inflate(R.layout.card_layout,
                viewGroup, false);

        return new DateViewHolder(itemView);
    }


    public static class DateViewHolder extends RecyclerView.ViewHolder {
        protected CardView cv;
        protected ImageView image;
        protected TextView name;
        protected RatingBar rating;
        protected RelativeLayout rl;
        public DateInfo date;
        public View view;


        public DateViewHolder(View v) {
            super(v);
            view = v;
            cv = (CardView)itemView.findViewById(R.id.cards);
            image = (ImageView)itemView.findViewById(R.id.date_image);
            name = (TextView)itemView.findViewById(R.id.txtName);
            rating = (RatingBar)itemView.findViewById(R.id.ratingBar);
            rl = (RelativeLayout)itemView.findViewById(R.id.cardView);
            rl.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    //Toast.makeText(v.getContext(), "Clicked card", Toast.LENGTH_LONG).show();
                    ((MainActivity)v.getContext()).HandleClick(date);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }

    public List<DateInfo> getDates() {
        return dateList;
    }

    public void setDateList(List<DateInfo> dateList) {
        this.dateList = dateList;
    }

}

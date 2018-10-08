package com.example.jonathan.dateoptions;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DateViewHolder> {
    private List<DateInfo> dateList;

    public RecyclerAdapter(List<DateInfo> dateList) {
        this.dateList = dateList;
    }

    @Override //Sets the values for the card view from the data Dakota is including
    public void onBindViewHolder(DateViewHolder dateViewHolder, int i) {
        dateViewHolder.image.setImageResource(dateList.get(i).pic);
        dateViewHolder.name.setText(dateList.get(i).name);
        dateViewHolder.rating.setNumStars(dateList.get(i).rating);
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


        public DateViewHolder(View v) {
            super(v);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            image = (ImageView)itemView.findViewById(R.id.date_image);
            name = (TextView)itemView.findViewById(R.id.txtName);
            rating = (RatingBar)itemView.findViewById(R.id.ratingBar);
        }
    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }



}

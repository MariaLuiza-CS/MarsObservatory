package com.example.myapplication.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.data.model.MarsData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListMoviesAdapter extends RecyclerView.Adapter<ListMoviesAdapter.ListMoviesViewHolder> {

    private List<MarsData> marsItem;

    public ListMoviesAdapter() {
        marsItem = new ArrayList<>();
    }


    public static class ListMoviesViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvListTitle;
        private final TextView tvListStatus;
        private final ImageView ivListPhoto;

        public ListMoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            tvListTitle = itemView.findViewById(R.id.tv_item_title);
            ivListPhoto = itemView.findViewById(R.id.iv_item_photo);
            tvListStatus = itemView.findViewById(R.id.tv_item_status);

        }

        public void bind(MarsData marsData) {
            tvListTitle.setText(marsData.getEarthDate());
            tvListStatus.setText("Status: " + marsData.getRoverResponse().getStatus());
            Picasso.get()
                    .load(marsData.getImgCamera()).into(ivListPhoto);

        }

    }

    @NonNull
    @Override
    public ListMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ListMoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMoviesViewHolder holder, int position) {
        holder.bind(marsItem.get(position));
    }

    @Override
    public int getItemCount() {
        return (marsItem != null && marsItem.size() > 0) ? marsItem.size() : 0;
    }

    public void setMarsItem(List<MarsData> marsItem) {
        this.marsItem = marsItem;
        notifyDataSetChanged();
    }

}

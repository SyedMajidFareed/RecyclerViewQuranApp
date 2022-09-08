package com.example.recyclerviewapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterRecitation  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<ListModel> EnglishSurahNames = new ArrayList<>();
    String req;

    RecyclerAdapterRecitation(String req) {
        this.req = req;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.surahnameview, parent, false);
        return new RecyclerAdapterRecitation.EnglishSurahVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListModel item = EnglishSurahNames.get(position);
        RecyclerAdapterRecitation.EnglishSurahVH ViewHolder = (RecyclerAdapterRecitation.EnglishSurahVH) holder;
        ViewHolder.Text.setText(item.getSurahName());


    }

    public void setData(ArrayList<ListModel> EnglishSurahNames) {
        this.EnglishSurahNames = EnglishSurahNames;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return EnglishSurahNames.size();
    }


    public static class EnglishSurahVH extends RecyclerView.ViewHolder {
        TextView Text;

        public EnglishSurahVH(@NonNull View itemView) {
            super(itemView);
            Text = itemView.findViewById(R.id.RVText);

        }
    }
}

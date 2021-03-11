package com.example.recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ProgrammingViewHolder> {

    SportsData[] sportsData;
    Context context;

    public ProgrammingAdapter(SportsData[] sportsData, MainActivity myActivity) {
        this.sportsData = sportsData;
        this.context = myActivity;
    }

    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {
        final SportsData sportsDataList = sportsData[position];
        holder.textView.setText(sportsDataList.getText());
        holder.subTextView.setText(sportsDataList.getSubText());
        holder.imageIcon.setImageResource(sportsDataList.getImage());

        holder.itemView.setOnClickListener(view -> Toast.makeText(context, sportsDataList.getText(), Toast.LENGTH_LONG));
    }

    @Override
    public int getItemCount() {
        return sportsData.length;
    }

    public static class ProgrammingViewHolder extends RecyclerView.ViewHolder {
        ImageView imageIcon;
        TextView textView;
        TextView subTextView;

        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);
            imageIcon = (ImageView) itemView.findViewById(R.id.image);
            textView = (TextView) itemView.findViewById(R.id.text);
            subTextView = (TextView) itemView.findViewById(R.id.sub_text);
        }
    }
}

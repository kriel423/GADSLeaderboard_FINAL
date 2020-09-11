package com.pluralsight.gadsleaderboard_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context mContext;
    List<Leader> mLeader;
    String combined;

    public RecyclerViewAdapter(Context context, List<Leader> leader)
    {
        mContext = context;
        mLeader = leader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.leaner_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.leaderName.setText(mLeader.get(position).getmName());
        combined = mLeader.get(position).getmHours() + " learning hours, "+mLeader.get(position).getmCountry();
        holder.leaderCountry.setText(combined);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView leaderName;
        private TextView leaderCountry;
        private TextView leaderHours;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            leaderName = itemView.findViewById(R.id.text_name);
            leaderCountry = itemView.findViewById(R.id.text_details);
        }
    }

    @Override
    public int getItemCount() {
        return mLeader.size();
    }

}


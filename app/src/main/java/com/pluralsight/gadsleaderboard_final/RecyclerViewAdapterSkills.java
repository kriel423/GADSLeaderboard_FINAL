package com.pluralsight.gadsleaderboard_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapterSkills extends RecyclerView.Adapter<RecyclerViewAdapterSkills.ViewHolder> {
    Context mContext;
    List<SkillIQ> mLeaderSkills;
    String combined;

    public RecyclerViewAdapterSkills(Context context, List<SkillIQ> skills)
    {
        mContext = context;
        mLeaderSkills = skills;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.skills_iq_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.leaderName.setText(mLeaderSkills.get(position).getmName());
        combined = mLeaderSkills.get(position).getmScore() + " skill IQ Score, " + mLeaderSkills.get(position).getmCountry();
        holder.leaderCountry.setText(combined);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView leaderName;
        private TextView leaderCountry;
        private TextView leaderScore;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            leaderName = itemView.findViewById(R.id.skill_iq_name);
            leaderCountry = itemView.findViewById(R.id.skill_iq_description);
        }
    }

    @Override
    public int getItemCount() {
        return mLeaderSkills.size();
    }
}

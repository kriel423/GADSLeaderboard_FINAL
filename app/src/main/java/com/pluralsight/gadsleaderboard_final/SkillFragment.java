package com.pluralsight.gadsleaderboard_final;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SkillFragment extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private List<SkillIQ> skillLeader;
    private RecyclerViewAdapterSkills mRecyclerViewAdapterSkills;

    public SkillFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.skill_fragment, container, false);
        recyclerView = v.findViewById(R.id.skill_view);
        mRecyclerViewAdapterSkills = new RecyclerViewAdapterSkills(getContext(), skillLeader);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mRecyclerViewAdapterSkills);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSkillList();
        //extractLeaderData();
    }

    private void extractLeaderData() {
//        skillLeader = new ArrayList<>();
//        private static String JSON_URL_IQ = "https://gadsapi.herokuapp.com/api/skilliq";
//        RequestQueue queue = Volley.newRequestQueue(getContext());
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL_IQ, null, new Response.Listener<JSONArray>() {
//
//            @Override
//            public void onResponse(JSONArray response) {
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject leaderObject = response.getJSONObject(i);
//                        SkillIQ skillIQ = new SkillIQ();
//                        skillIQ.setmName(leaderObject.getString("name"));
//                        skillIQ.setmScore(leaderObject.getInt("score"));
//                        skillIQ.setmCountry(leaderObject.getString("country"));
//                        skillLeader.add(skillIQ);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//                mRecyclerViewAdapterSkills.notifyDataSetChanged();
//                mRecyclerViewAdapterSkills = new RecyclerViewAdapterSkills(getContext(), skillLeader);
//                recyclerView.setAdapter(mRecyclerViewAdapterSkills);
//            }
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.i("tag", "onErrorResponse:" + error.getMessage());
//            }
//        });
//
//        queue.add(jsonArrayRequest);
    }

    private void getSkillList() {
        skillLeader = new ArrayList<>();
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 277, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 288, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 200, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 254, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 260, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 287, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 167, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 294, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 259, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 190, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 175, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 156, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 192, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 215, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 239, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 185, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Oluwatobi", 180, "Nigeria"));
        skillLeader.add(new SkillIQ("Perry Sam", 255, "South Africa"));
        skillLeader.add(new SkillIQ("Perry Zimo", 259, "Tanzania"));
        skillLeader.add(new SkillIQ("Paul Cheng", 202, "Zimbabwe"));
    }
}




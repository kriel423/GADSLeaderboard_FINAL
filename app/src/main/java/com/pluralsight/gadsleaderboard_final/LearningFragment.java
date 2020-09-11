package com.pluralsight.gadsleaderboard_final;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LearningFragment extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private List<Leader> listLeaders;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    public LearningFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.learning_fragment, container, false);
        recyclerView = v.findViewById(R.id.learning_view);
        mRecyclerViewAdapter = new RecyclerViewAdapter(getContext(), listLeaders);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mRecyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listLeaders = new ArrayList<>();
        listLeaders.add(new Leader("Kojo Yeboah", 73, "Ghana"));
        listLeaders.add(new Leader("Sam George", 70, "Nigeria"));
        listLeaders.add(new Leader("Kojo Asante", 67, "Kenya"));
        listLeaders.add(new Leader("Eric Yenge", 105, "Tanzania"));
        listLeaders.add(new Leader("Kojo Yeboah", 117, "Ghana"));
        listLeaders.add(new Leader("Sam George", 59, "Nigeria"));
        listLeaders.add(new Leader("Kojo Asante", 74, "Kenya"));
        listLeaders.add(new Leader("Eric Yenge", 86, "Tanzania"));
        listLeaders.add(new Leader("Kojo Yeboah", 84, "Ghana"));
        listLeaders.add(new Leader("Sam George", 110, "Nigeria"));
        listLeaders.add(new Leader("Kojo Asante", 79, "Kenya"));
        listLeaders.add(new Leader("Eric Yenge", 102, "Tanzania"));
        listLeaders.add(new Leader("Kojo Yeboah", 87, "Ghana"));
        listLeaders.add(new Leader("Sam George", 94, "Nigeria"));
        listLeaders.add(new Leader("Kojo Asante", 98, "Kenya"));
        listLeaders.add(new Leader("Eric Yenge", 93, "Tanzania"));
        listLeaders.add(new Leader("Kojo Yeboah", 58, "Ghana"));
        listLeaders.add(new Leader("Sam George", 101, "Nigeria"));
        listLeaders.add(new Leader("Kojo Asante", 89, "Kenya"));
        listLeaders.add(new Leader("Eric Yenge", 97, "Tanzania"));

    }

    private void extractLeaderData() {
//        listLeaders = new ArrayList<>();
//        private static String JSON_URL_LEARNERS = "https://gadsapi.herokuapp.com/api/hours";
//        RequestQueue queue = Volley.newRequestQueue(getContext());
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL_LEARNERS, null, new Response.Listener<JSONArray>() {
//
//            @Override
//            public void onResponse(JSONArray response) {
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject leaderObject = response.getJSONObject(i);
//                        Leader leader = new Leader();
//                        leader.setmName(leaderObject.getString("name"));
//                        leader.setmHours(leaderObject.getInt("hours"));
//                        leader.setmCountry(leaderObject.getString("country"));
//                        listLeaders.add(leader);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//                mRecyclerViewAdapter.notifyDataSetChanged();
//                mRecyclerViewAdapter = new RecyclerViewAdapter(getContext(), listLeader);
//                recyclerView.setAdapter(mRecyclerViewAdapter);
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
}

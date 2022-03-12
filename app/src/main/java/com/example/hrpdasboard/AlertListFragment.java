package com.example.hrpdasboard;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlertListFragment extends Fragment {

    RecyclerView eventRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alert_list, container, false);

        eventRecyclerView = view.findViewById(R.id.recycler_view);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        AlertAdapter adapter = new AlertAdapter();
        eventRecyclerView.setAdapter(adapter);

        return view;
    }

    private class AlertViewHolder extends RecyclerView.ViewHolder {

        String eventText;
        TextView eventTextView;

        public AlertViewHolder(@NonNull View itemView) {
            super(itemView);
            eventTextView = (TextView) itemView.findViewById(R.id.text_event);
        }

        public void bind(String eventDetails) {
            eventText = eventDetails;
            eventTextView.setText(eventDetails);
        }
    }

    private class AlertAdapter extends RecyclerView.Adapter<AlertViewHolder> {

        String[] eventsList = {"Today, 11/3/2021",
                "No new incoming events",
                "Sunday, 12/3/2021",
                "Thu Hien's Birthday",
                "Monday, 12/3/2021",
                "Tan's 5-years working anniversary",
                "Tuesday, 12/3/2021",
                "Hong Nhung's Wedding",
                "Wednesday, 12/3/2021",
                "Anh Duy's Birthday"};

        @NonNull
        @Override
        public AlertViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.item_recycler_view, parent, false);

            return new AlertViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AlertViewHolder holder, int position) {
            holder.bind(eventsList[position]);
            if (position%2==0) {
                holder.eventTextView.setTextColor(Color.BLACK);
                holder.eventTextView.setTextSize(20);
                holder.eventTextView.setBackgroundColor(Color.WHITE);
                holder.itemView.setBackgroundColor(Color.WHITE);
                holder.eventTextView.setGravity(Gravity.START);
            }
        }

        @Override
        public int getItemCount() {
            return eventsList.length;
        }
    }
}

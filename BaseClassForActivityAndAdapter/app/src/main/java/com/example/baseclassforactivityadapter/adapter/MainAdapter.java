package com.example.baseclassforactivityadapter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseclassforactivityadapter.R;
import com.example.baseclassforactivityadapter.activity.MainActivity;
import com.example.baseclassforactivityadapter.model.Member;

import java.util.List;

public class MainAdapter extends BaseAdapter {

    private MainActivity activity;
    private List<Member> members;

    public MainAdapter(MainActivity activity, List<Member> members) {
        this.activity = activity;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member =  members.get(position);

        if (holder instanceof CustomViewHolder){
            LinearLayout lay_click = ((CustomViewHolder) holder).lay_click;
            ((CustomViewHolder) holder).first_name.setText(member.getFirstName());
           ((CustomViewHolder) holder).last_name.setText(member.getLastName());


            lay_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.openItemDetails(member);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView first_name, last_name;
        public LinearLayout lay_click;

        public CustomViewHolder(View v){
            super(v);
            view = v;

            lay_click = view.findViewById(R.id.lay_click);

            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);

        }

    }

}

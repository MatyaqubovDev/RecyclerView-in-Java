package dev.matyaqubov.recyclerviewinsiderecyclerviewjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dev.matyaqubov.recyclerviewinsiderecyclerviewjava.R;
import dev.matyaqubov.recyclerviewinsiderecyclerviewjava.model.SubMember;

public class SubMemberAdapter extends  RecyclerView.Adapter<SubMemberAdapter.ViewSubHolder> {
    private Context context;
    private ArrayList<SubMember> subMembers;

    public SubMemberAdapter(Context context, ArrayList<SubMember> subMembers) {
        this.context = context;
        this.subMembers = subMembers;
    }

    @NonNull
    @Override
    public ViewSubHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sub_elements,parent,false);
        return new ViewSubHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewSubHolder holder, int position) {

        SubMember subMember=subMembers.get(position);


    }

    @Override
    public int getItemCount() {
        return subMembers.size();
    }

    class ViewSubHolder extends RecyclerView.ViewHolder {

        View view;
//        RecyclerView recyclerView;
        public ViewSubHolder(@NonNull View view) {
            super(view);
//            recyclerView=view.findViewById(R.id.rv_sub);

        }
    }
}

package dev.matyaqubov.recyclerviewinsiderecyclerviewjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dev.matyaqubov.recyclerviewinsiderecyclerviewjava.R;
import dev.matyaqubov.recyclerviewinsiderecyclerviewjava.model.Member;
import dev.matyaqubov.recyclerviewinsiderecyclerviewjava.model.SubMember;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Member> members;
    private final Context context;

    private static final int TYPE_LIST = 0;
    private static final int TYPE_VIEW = 1;


    public MyRecyclerViewAdapter(Context context, ArrayList<Member> members) {
        this.members = members;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
       Member member=members.get(position);
       if (member.getSubmembers()!=null) return TYPE_LIST;

       return TYPE_VIEW;

    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==TYPE_VIEW){
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member,parent,false);
            return new CustomViewHoler(view);
        }

        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sub_layout,parent,false);
        return new CustomListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member=members.get(position);
        if (holder instanceof CustomListHolder){
            RecyclerView recyclerView=((CustomListHolder) holder).recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(context,1,GridLayoutManager.HORIZONTAL,false));
            ArrayList<SubMember> subMembers=member.getSubmembers();
            refreshSubAdapter(recyclerView,subMembers);
        }

    }

    private void refreshSubAdapter(RecyclerView recyclerView, ArrayList<SubMember> subMembers) {
        SubMemberAdapter adapter = new SubMemberAdapter(context, subMembers);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }
    class CustomViewHoler extends RecyclerView.ViewHolder{

        View view;
        TextView nameTextview,phoneTextView;
        public CustomViewHoler(@NonNull View view) {
            super(view);
            this.view=view;
            nameTextview=view.findViewById(R.id.tv_name);
            phoneTextView=view.findViewById(R.id.tv_phone);

        }
    }
    class CustomListHolder extends RecyclerView.ViewHolder{

        RecyclerView recyclerView;
        public CustomListHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.rv_sub);
        }
    }
}





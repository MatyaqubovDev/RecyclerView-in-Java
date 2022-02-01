package dev.matyaqubov.recyclerviewinsiderecyclerviewjava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import dev.matyaqubov.recyclerviewinsiderecyclerviewjava.R;
import dev.matyaqubov.recyclerviewinsiderecyclerviewjava.adapter.MyRecyclerViewAdapter;
import dev.matyaqubov.recyclerviewinsiderecyclerviewjava.model.Member;
import dev.matyaqubov.recyclerviewinsiderecyclerviewjava.model.SubMember;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvMain;
    Context context;
    MyRecyclerViewAdapter myRecyclerViewAdapter;
    ArrayList<Member> members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        context=this;
        members=new ArrayList<>();
        prepareMember();
        myRecyclerViewAdapter=new MyRecyclerViewAdapter(context,members);
        rvMain=findViewById(R.id.rv_main);
        rvMain.setAdapter(myRecyclerViewAdapter);
        rvMain.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void prepareMember() {
        for (int i = 0; i < 20; i++) {
            if (i==3 || i==7){
                members.add(new Member("Alisher"+i,"+998975259712",prepareSubMember()));
            } else {
                members.add(new Member("Alisher"+i,"+998975259712",null));
            }
        }
    }

    private ArrayList<SubMember> prepareSubMember() {
        ArrayList<SubMember> subMembers = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            subMembers.add(new SubMember("Odilbek"+i,"+99895635427"));
        }
        return subMembers;
    }
}
package com.example.recyclerviewasgridview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recyclerviewasgridview.R;
import com.example.recyclerviewasgridview.adapter.CustomViewAdapter;
import com.example.recyclerviewasgridview.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        List<Member> members = prepareMember();
        refreshAdapter(members);
    }

    private void initViews() {
        recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,3));

    }
    private void refreshAdapter(List<Member> members) {
        CustomViewAdapter adapter = new CustomViewAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }
    public List<Member> prepareMember () {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            if (i == 2 || i == 7) {
                members.add(new Member("Bogibek", "Matyaqubov"));
            } else {
                members.add(new Member("Odilbek", "Matyaqubov"));
            }
        }
        return members;
    }
}

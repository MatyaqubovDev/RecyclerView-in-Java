package com.example.baseclassforactivityadapter.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseclassforactivityadapter.R;
import com.example.baseclassforactivityadapter.adapter.DetailsAdapter;
import com.example.baseclassforactivityadapter.model.Member;

import java.util.List;

public class DetailsActivity extends BaseActivity {

    private Context context;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    @SuppressLint("WrongViewCast")
    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members) {
        DetailsAdapter adapter = new DetailsAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }
}

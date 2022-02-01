package com.example.baseclassforactivityadapter.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.baseclassforactivityadapter.R;
import com.example.baseclassforactivityadapter.adapter.MainAdapter;
import com.example.baseclassforactivityadapter.model.Member;

import java.util.List;

public class MainActivity extends BaseActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Member> members = prepareMemberList();

        initViews();
        refreshAdapter(members);
    }


    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members) {
        MainAdapter adapter = new MainAdapter(MainActivity.this ,members);
        recyclerView.setAdapter(adapter);
    }

    public void openItemDetails(Member member){
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }


}
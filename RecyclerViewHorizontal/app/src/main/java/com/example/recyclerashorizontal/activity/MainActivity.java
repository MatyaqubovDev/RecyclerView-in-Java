package com.example.recyclerashorizontal.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recyclerashorizontal.R;
import com.example.recyclerashorizontal.adapter.CustomViewAdapter;
import com.example.recyclerashorizontal.model.Member;

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

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
    }

    private void refreshAdapter(List<Member> members){
        CustomViewAdapter adapter = new CustomViewAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList(){
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            if (i == 2 || i == 7){
                members.add(new Member("Linus","Torvald"));
            } else {
                members.add(new Member("Alisher","Navoiy"));
            }

        }
        members.add(new Member());
        return members;
    }
}

package dev.matyaqubov.recyclerviewinsidenestedscrollviewjava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import dev.matyaqubov.recyclerviewinsidenestedscrollviewjava.R;
import dev.matyaqubov.recyclerviewinsidenestedscrollviewjava.model.Member;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Member> members;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView=findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }
}
package com.example.recyclerviewwithanimationjava_13.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.recyclerviewwithanimationjava_13.R;
import com.example.recyclerviewwithanimationjava_13.adapter.CustomAdapter;
import com.example.recyclerviewwithanimationjava_13.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        List<Member> members = prepareList();
        refreshAdapter(members);

    }

    void initViews() {
        context = this;
        rvMain = findViewById(R.id.rv_main);
        rvMain.setLayoutManager(new GridLayoutManager(context, 1));

        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        rvMain.setLayoutAnimation(controller);
    }

    void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context, members);
        rvMain.setAdapter(adapter);
    }

    List<Member> prepareList() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            members.add(new Member("Odilbek"));
        }
        return members;
    }

}

package com.example.baseclassforactivityadapter.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baseclassforactivityadapter.model.Member;
import com.example.baseclassforactivityadapter.network.BaseServer;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity implements BaseServer {

    protected String getServer(){
        if (IS_TESTER){
            return SERVER_DEVELOPMENT;
        }
        return SERVER_DEPLOYMENT;
    }
    protected List<Member> prepareMemberList(){
        List<Member> members = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            members.add(new Member(" Bogibek " + i," Matyaqubov "+ i));
        }
        return members;
    }

    //Null-Safe, short-circuit evolution
    protected static boolean isEmpty(final String s){
        return s == null || s.trim().isEmpty();
    }

}

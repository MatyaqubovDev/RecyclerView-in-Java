package dev.matyaqubov.recyclerviewinsiderecyclerviewjava.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String phone;
    private ArrayList<SubMember> submembers;

    public Member(String name, String phone, ArrayList<SubMember> subMembers) {
        this.name = name;
        this.phone = phone;
        this.submembers=subMembers;
    }

    public String getName() {
        return name;
    }

    public ArrayList<SubMember> getSubmembers() {
        return submembers;
    }

    public void setSubmembers(ArrayList<SubMember> submembers) {
        this.submembers = submembers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

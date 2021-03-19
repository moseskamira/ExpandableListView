package com.team295.expandablelistview.repository;

import com.team295.expandablelistview.model.StringModel;

import java.util.ArrayList;
import java.util.List;

public class StringArrayData {
    public static List<StringModel> returnFootballArrayList() {
        List<StringModel> football = new ArrayList<>();
        football.add(new StringModel("Brazil"));
        football.add(new StringModel("Spain"));
        football.add(new StringModel("Germany"));
        football.add(new StringModel("Netherlands"));
        football.add(new StringModel("Italy"));
        return football;
    }

    public static List<StringModel> returnCricketArrayList() {
        List<StringModel> cricket = new ArrayList<>();
        cricket.add(new StringModel("India"));
        cricket.add(new StringModel("Pakistan"));
        cricket.add(new StringModel("Australia"));
        cricket.add(new StringModel("England"));
        cricket.add(new StringModel("South Africa"));
        return cricket;
    }

    public static List<StringModel> returnRequestForm() {
        List<StringModel> requestForm = new ArrayList<>();
        requestForm.add(new StringModel("Open RequestForm"));
        return requestForm;
    }

}

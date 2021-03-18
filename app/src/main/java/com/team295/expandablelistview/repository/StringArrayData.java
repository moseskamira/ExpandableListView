package com.team295.expandablelistview.repository;

import java.util.ArrayList;
import java.util.List;

public class StringArrayData {
    public static List<String> returnFootballArrayList() {
        List<String> football = new ArrayList<>();
        football.add("Brazil");
        football.add("Spain");
        football.add("Germany");
        football.add("Netherlands");
        football.add("Italy");
        return football;
    }

    public static List<String> returnCricketArrayList() {
        List<String> cricket = new ArrayList<>();
        cricket.add("India");
        cricket.add("Pakistan");
        cricket.add("Australia");
        cricket.add("England");
        cricket.add("South Africa");
        return cricket;
    }

    public static List<String> returnRequestForm() {
        List<String> requestForm = new ArrayList<>();
        requestForm.add("Open RequestForm");
        return requestForm;
    }

}

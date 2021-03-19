package com.team295.expandablelistview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.team295.expandablelistview.R;
import com.team295.expandablelistview.adapter.CustomExpandableListAdapter;
import com.team295.expandablelistview.model.StringModel;
import com.team295.expandablelistview.viewModel.StringArrayDataViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<StringModel>> expandableListDetail;
    StringArrayDataViewModel stringArrayDataViewModel;
    List<StringModel> footballData;
    List<StringModel> cricketData;
    List<StringModel> requestForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = findViewById(R.id.expandableListView);
        stringArrayDataViewModel = new ViewModelProvider(this).get(StringArrayDataViewModel
                .class);
        footballData = new ArrayList<>();
        cricketData = new ArrayList<>();
        requestForm = new ArrayList<>();
        expandableListDetail = getData();
        expandableListTitle = new ArrayList<>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle,
                expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                                        int childPosition, long id) {
                if (Objects.requireNonNull(expandableListDetail.get(expandableListTitle
                        .get(groupPosition))).get(childPosition).getStringName()
                        .equalsIgnoreCase("Open RequestForm")) {
                    startActivity(new Intent(MainActivity.this, RequestFormActivity
                            .class));
                }else {
                    Toast.makeText(getApplicationContext(), expandableListTitle
                            .get(groupPosition) + " -> " + Objects.requireNonNull(expandableListDetail.get(
                            expandableListTitle.get(groupPosition))).get(childPosition),
                            Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    public HashMap<String, List<StringModel>> getData() {
        HashMap<String, List<StringModel>> expandableListDetail = new HashMap<>();
        expandableListDetail.put("FOOTBALL TEAMS", retrieveFootballData());
        expandableListDetail.put("CRICKET TEAMS",retrieveCricketData() );
        expandableListDetail.put("REQUEST FORM", retrieveRequestForm());
        return expandableListDetail;
    }

    private List<StringModel> retrieveFootballData() {
        stringArrayDataViewModel.fetchFootBallLiveData().observe(this, new Observer<List<StringModel>>() {
            @Override
            public void onChanged(List<StringModel> strings) {
                footballData.addAll(strings);
            }
        });
        return footballData;
    }

    private List<StringModel> retrieveCricketData() {
        stringArrayDataViewModel.fetchCricketLiveData().observe(this, new Observer<List<StringModel>>() {
            @Override
            public void onChanged(List<StringModel> strings) {
               cricketData.addAll(strings);
            }
        });
        return cricketData;
    }

    private List<StringModel> retrieveRequestForm() {
        stringArrayDataViewModel.fetchRequestForm().observe(this, new Observer<List<StringModel>>() {
            @Override
            public void onChanged(List<StringModel> strings) {
                requestForm.addAll(strings);
            }
        });
        return requestForm;
    }


}
package com.team295.expandablelistview.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.team295.expandablelistview.R;
import com.team295.expandablelistview.model.StringModel;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> expandableListTitle;
    private HashMap<String, List<StringModel>> expandableListDetail;

    public CustomExpandableListAdapter(Context mContext, List<String> mExpandableListTitle,
                                       HashMap<String, List<StringModel>> mExpandableListDetail) {
        this.context = mContext;
        this.expandableListTitle = mExpandableListTitle;
        this.expandableListDetail = mExpandableListDetail;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return Objects.requireNonNull(this.expandableListDetail.get(this.expandableListTitle.get(listPosition)))
                .get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        final StringModel expandedListModel = (StringModel) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);convertView = layoutInflater
                    .inflate(R.layout.list_item, null);
        }
        TextView expandedListTextView = convertView.findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListModel.getStringName());
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return Objects.requireNonNull(this.expandableListDetail.get(this.expandableListTitle
                .get(listPosition))).size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);convertView = layoutInflater
                    .inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = convertView.findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}


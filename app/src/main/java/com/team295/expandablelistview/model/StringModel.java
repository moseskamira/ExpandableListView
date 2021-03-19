package com.team295.expandablelistview.model;

import androidx.annotation.NonNull;

public class StringModel {
    private String stringName;

    public StringModel(String stringName) {
        this.stringName = stringName;
    }

    public String getStringName() {
        return stringName;
    }

    public void setStringName(String stringName) {
        this.stringName = stringName;
    }

    @Override
    public @NonNull String toString() {
        return "StringModel{" +
                "stringName='" + stringName + '\'' +
                '}';
    }
}

package com.team295.expandablelistview.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.team295.expandablelistview.repository.StringArrayData;

import java.util.List;

public class StringArrayDataViewModel extends ViewModel {
    MutableLiveData<List<String>> footballResponseData;
    MutableLiveData<List<String>> cricketResponseData;
    MutableLiveData<List<String>> requestFormData;

    public StringArrayDataViewModel() {
        footballResponseData = new MutableLiveData<>();
        cricketResponseData = new MutableLiveData<>();
        requestFormData = new MutableLiveData<>();
    }

    public MutableLiveData<List<String>> fetchFootBallLiveData() {
        List<String> data = StringArrayData.returnFootballArrayList();
        footballResponseData.postValue(data);
        return footballResponseData;
    }

    public MutableLiveData<List<String>> fetchCricketLiveData() {
        List<String> data = StringArrayData.returnCricketArrayList();
        cricketResponseData.postValue(data);
        return cricketResponseData;
    }

    public MutableLiveData<List<String>> fetchRequestForm() {
        List<String> data = StringArrayData.returnRequestForm();
        requestFormData.postValue(data);
        return requestFormData;
    }


}

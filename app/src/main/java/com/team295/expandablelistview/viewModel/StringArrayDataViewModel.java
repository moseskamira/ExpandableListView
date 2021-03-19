package com.team295.expandablelistview.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.team295.expandablelistview.model.StringModel;
import com.team295.expandablelistview.repository.StringArrayData;

import java.util.List;

public class StringArrayDataViewModel extends ViewModel {
    MutableLiveData<List<StringModel>> footballResponseData;
    MutableLiveData<List<StringModel>> cricketResponseData;
    MutableLiveData<List<StringModel>> requestFormData;

    public StringArrayDataViewModel() {
        footballResponseData = new MutableLiveData<>();
        cricketResponseData = new MutableLiveData<>();
        requestFormData = new MutableLiveData<>();
    }

    public MutableLiveData<List<StringModel>> fetchFootBallLiveData() {
        List<StringModel> data = StringArrayData.returnFootballArrayList();
        footballResponseData.postValue(data);
        return footballResponseData;
    }

    public MutableLiveData<List<StringModel>> fetchCricketLiveData() {
        List<StringModel> data = StringArrayData.returnCricketArrayList();
        cricketResponseData.postValue(data);
        return cricketResponseData;
    }

    public MutableLiveData<List<StringModel>> fetchRequestForm() {
        List<StringModel> data = StringArrayData.returnRequestForm();
        requestFormData.postValue(data);
        return requestFormData;
    }


}

package com.alyndroid.architecturepatternstutorialshomework.UI;

import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumberViewModel extends ViewModel {


    NumberView numberView;
    MutableLiveData <Double>mutableLiveData =new MutableLiveData<Double>();
    public NumberModel getResult(){
        return new DataBase().getNumbers();
    }
    public void getMulRes(){
        double res =getResult().getFirstNum()*getResult().getSecondNum();
        mutableLiveData.setValue(res);
    }
}

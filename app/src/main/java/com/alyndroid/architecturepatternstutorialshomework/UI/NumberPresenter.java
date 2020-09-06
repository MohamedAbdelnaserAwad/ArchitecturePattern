package com.alyndroid.architecturepatternstutorialshomework.UI;

import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class NumberPresenter {

    NumberView numberView;


    public NumberPresenter(NumberView numberView) {
        this.numberView = numberView;
    }

    public NumberModel getResult(){
        return new DataBase().getNumbers();
    }
     public void getDivRes(){
        double res =getResult().getFirstNum()/getResult().getSecondNum();
        numberView.onGetDivResult(res);
     }

}

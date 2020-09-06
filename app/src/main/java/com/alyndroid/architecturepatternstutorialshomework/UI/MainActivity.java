package com.alyndroid.architecturepatternstutorialshomework.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.R;

import java.util.Observable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NumberView, View.OnClickListener {

    @BindView(R.id.plus_button)
    Button plusButton;
    @BindView(R.id.mul_button)
    Button mulButton;
    @BindView(R.id.div_button)
    Button divButton;
    @BindView(R.id.mul_result_textView)
    TextView mulResultTextView;
    @BindView(R.id.plus_result_textView)
    TextView plusResultTextView;
    @BindView(R.id.div_result_textView)
    TextView divResultTextView;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView5)
    TextView textView5;
    NumberPresenter numberPresenter ;
    NumberViewModel numberViewModel=new NumberViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mulButton.setOnClickListener(this);
        numberPresenter =new NumberPresenter(this);
        numberViewModel=ViewModelProviders.of(this).get(NumberViewModel.class);
        numberViewModel.mutableLiveData.observe(MainActivity.this, new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                mulResultTextView.setText(""+aDouble);
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int res = Integer.parseInt((String) textView4.getText())+Integer.parseInt((String) textView5.getText());
                plusResultTextView.setText(""+res);
            }
        });
        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPresenter.getDivRes();
            }
        });


    }


    @Override
    public void onGetDivResult(double res) {
        divResultTextView.setText(""+res);
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==mulButton.getId()){
            numberViewModel.getMulRes();
        }
    }
}

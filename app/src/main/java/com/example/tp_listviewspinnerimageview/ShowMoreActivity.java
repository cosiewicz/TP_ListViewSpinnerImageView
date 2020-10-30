package com.example.tp_listviewspinnerimageview;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class ShowMoreActivity extends AppCompatActivity {

    private Country country;
    private ImageView iv_flag;
    private TextView tv_countryName;
    private TextView tv_capital;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmore);
        country=(Country)getIntent().getSerializableExtra("country");
        init();

        iv_flag.setImageResource(country.getFlagId());
        tv_countryName.setText(country.getCountryName());
        tv_capital.setText(country.getCapital());
    }


    public void init(){
        iv_flag = findViewById(R.id.imageViewFlagMore);
        tv_countryName=findViewById(R.id.textViewCountryNameMore);
        tv_capital = findViewById(R.id.textViewCapitalMore);
    }



}

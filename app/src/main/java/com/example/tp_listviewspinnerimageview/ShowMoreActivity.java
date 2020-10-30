package com.example.tp_listviewspinnerimageview;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

public class ShowMoreActivity extends AppCompatActivity {

    private Country country;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmore);
       // country=(Country)getIntent().getSerializableExtra("country");
       // Log.i("debug",country.getCountryName());

    }




}

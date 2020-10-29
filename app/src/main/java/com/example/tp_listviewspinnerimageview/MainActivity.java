package com.example.tp_listviewspinnerimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.controls.Control;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Country> countries;
    private ArrayList<Continent> continents;
    private Spinner spinner;
    private ListView listView;
    private ArrayAdapter<Continent> spinnerAdapter;


    // TEST

   AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
       @Override
       public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
           Continent continent=(Continent)parent.getAdapter().getItem(position);
           ArrayList<Country> c = Country.getCountryWithContinent(countries,continent);

           for (Country val : c
                ) {
                Log.i("debug",val.getCountryName());
           }

       }

       @Override
       public void onNothingSelected(AdapterView<?> parent) {

       }
   };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countries=new ArrayList<>();
        continents=new ArrayList<>();
        insertData();
        init();


    }

    private void init(){
        spinner = findViewById(R.id.spinner);




        spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,continents);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(spinnerListener);

    }

    private void insertData(){
        continents.add(new Continent(0,getString(R.string.europe)));
        continents.add(new Continent(1,getString(R.string.america)));
        countries.add(new Country(R.drawable.albania,getString(R.string.albania),getString(R.string.c_albania),continents.get(1)));
        countries.add(new Country(R.drawable.andorra,getString(R.string.andorra),getString(R.string.c_andorra),continents.get(1)));
        countries.add(new Country(R.drawable.armenia,getString(R.string.armenia),getString(R.string.c_armenia),continents.get(1)));
        countries.add(new Country(R.drawable.france,getString(R.string.france),getString(R.string.c_france),continents.get(1)));
        countries.add(new Country(R.drawable.germany_,getString(R.string.germany),getString(R.string.c_germany),continents.get(1)));
    }


    public ArrayList<Country> getCountries() {
        return countries;
    }
}
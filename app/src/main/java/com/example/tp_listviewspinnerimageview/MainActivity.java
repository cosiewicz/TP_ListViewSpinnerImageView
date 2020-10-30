package com.example.tp_listviewspinnerimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.Control;
import android.util.Log;
import android.view.LayoutInflater;
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
    private MonAdapter adapter;
    private static final int APPEL_SHOW_MOREACTIVIRY=1;

   AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
       @Override
       public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
           Continent continent=(Continent)parent.getAdapter().getItem(position);
           adapter.setCountries(Country.getCountryWithContinent(countries,continent));
           adapter.notifyDataSetChanged();
       }
       @Override
       public void onNothingSelected(AdapterView<?> parent) {
       }
   };

    AdapterView.OnItemClickListener listViewListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Country c =(Country) parent.getAdapter().getItem(position);

            Intent intent = new Intent (getBaseContext(), ShowMoreActivity.class);
            intent.putExtra("country",c);
            startActivity(intent);
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
        listView = findViewById(R.id.listViewContinent);
        spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,continents);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(spinnerListener);
        adapter = new MonAdapter(this,new ArrayList<Country>());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listViewListener);
    }

    private void insertData(){
        continents.add(new Continent(0,getString(R.string.europe)));
        continents.add(new Continent(1,getString(R.string.america)));

        countries.add(new Country(R.drawable.albania,getString(R.string.albania),getString(R.string.c_albania),continents.get(0)));
        countries.add(new Country(R.drawable.andorra,getString(R.string.andorra),getString(R.string.c_andorra),continents.get(0)));
        countries.add(new Country(R.drawable.armenia,getString(R.string.armenia),getString(R.string.c_armenia),continents.get(0)));
        countries.add(new Country(R.drawable.france,getString(R.string.france),getString(R.string.c_france),continents.get(0)));
        countries.add(new Country(R.drawable.germany_,getString(R.string.germany),getString(R.string.c_germany),continents.get(0)));
        countries.add(new Country(R.drawable.belarus,getString(R.string.belarus),getString(R.string.c_belarus),continents.get(0)));
        countries.add(new Country(R.drawable.spain,getString(R.string.spain),getString(R.string.c_spain),continents.get(0)));
        countries.add(new Country(R.drawable.croatia,getString(R.string.croatie),getString(R.string.c_croatie),continents.get(0)));
        countries.add(new Country(R.drawable.belgium,getString(R.string.belgium),getString(R.string.c_belgium),continents.get(0)));


        countries.add(new Country(R.drawable.united_states,getString(R.string.united_states),getString(R.string.c_united_states),continents.get(1)));
        countries.add(new Country(R.drawable.argentina,getString(R.string.argentina),getString(R.string.c_argentina),continents.get(1)));
        countries.add(new Country(R.drawable.peru,getString(R.string.peru),getString(R.string.c_peru),continents.get(1)));
        countries.add(new Country(R.drawable.colombia,getString(R.string.colombia),getString(R.string.c_colombia),continents.get(1)));
        countries.add(new Country(R.drawable.belize,getString(R.string.belize),getString(R.string.c_belize),continents.get(1)));

    }


    public ArrayList<Country> getCountries() {
        return countries;
    }
}
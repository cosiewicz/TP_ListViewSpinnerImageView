package com.example.tp_listviewspinnerimageview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Country> countries;
    private LayoutInflater layoutInflater;



    public MonAdapter(Context context,ArrayList<Country>countries){
        this.context=context;
        this.countries=countries;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override

    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ConstraintLayout itemView;

        if(convertView==null){
            itemView=(ConstraintLayout)layoutInflater.inflate(R.layout.listview,parent,false);
        }
        else{
            itemView = (ConstraintLayout)convertView;
        }

        ImageView img = itemView.findViewById(R.id.imageViewFlag);
        TextView tv_countryName = itemView.findViewById(R.id.textViewCountryName);
        TextView tv_capital = itemView.findViewById(R.id.textViewCapital);

        img.setImageResource(countries.get(position).getFlagId());
        tv_capital.setText(countries.get(position).getCapital());
        tv_countryName.setText(countries.get(position).getCountryName());
        return itemView;
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }
}
